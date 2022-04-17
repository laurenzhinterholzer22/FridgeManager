package at.jku.ce.fridge.controller;

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
    public Optional<User> getUser(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Integer id) {
        if(userService.findById(id).isPresent()) {
            userService.deleteById(id);
        }
    }

    @PostMapping("/user")
    User newUser(@RequestBody User user) {
        return userService.save(user);
    }

}
