package at.jku.ce.fridge.controller;

import at.jku.ce.fridge.model.Fridge;
import at.jku.ce.fridge.model.ShoppingList;
import at.jku.ce.fridge.model.User;
import at.jku.ce.fridge.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private final IUserService userService;

    UserController (IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return  userService.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id) {
        if(userService.findById(id).isPresent()) {
            userService.deleteById(id);
        }
    }

    @PostMapping(value = "/user", consumes = {"application/json"})
    User newUser(@RequestBody User user) {
        user.setFridge(new Fridge());
        user.setShoppingList(new ShoppingList());
        return userService.save(user);
    }

}
