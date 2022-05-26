package at.jku.ce.fridge.controller;

import at.jku.ce.fridge.model.Fridge;
import at.jku.ce.fridge.model.ShoppingList;
import at.jku.ce.fridge.model.User;
import at.jku.ce.fridge.service.IFridgeService;
import at.jku.ce.fridge.service.IShoppingListService;
import at.jku.ce.fridge.service.IUserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private final IUserService userService;

    @Autowired
    private final IFridgeService fridgeService;

    @Autowired
    private final IShoppingListService shoppingListService;

    UserController(IUserService userService, IFridgeService fridgeService, IShoppingListService shoppingListService) {
        this.userService = userService;
        this.fridgeService = fridgeService;
        this.shoppingListService = shoppingListService;
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return  userService.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/user/fridge/{id}")
    public Long getUserFridge(@PathVariable Long id) {
        if (userService.findById(id).isPresent()) {
            if (fridgeService.existsById(userService.findById(id).get().getFridge().getId())) {
                return fridgeService.findById(userService.findById(id).get().getFridge().getId()).get().getId();
            }else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user/shoppingList/{id}")
    public Long getUserShoppingList(@PathVariable Long id) {
        if (userService.findById(id).isPresent()) {
            if (shoppingListService.existsById(userService.findById(id).get().getShoppingList().getId())) {
                return shoppingListService.findById(userService.findById(id).get().getShoppingList().getId()).get().getId();
            }else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id) {
        if(userService.findById(id).isPresent()) {
            userService.deleteById(id);
        }
    }

    @PostMapping(value = "/user", consumes = {"application/json"})
    User newUser(@RequestBody User user) {
        try {
            user.setFridge(new Fridge());
            user.setShoppingList(new ShoppingList());
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            return userService.save(user);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/user/login", consumes = {"application/json"})
    Optional<User> loginUser(@RequestBody User user) {
        try {
            if (userService.findById(user.getId()).isPresent()) {
                Optional<User> user1 = userService.findById(user.getId());
                if (BCrypt.checkpw(user.getPassword(), user1.get().getPassword()) && user1.get().getEmail().equals(user.getEmail())) {
                    return user1;
                }
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
