package org.example.mvc.controller;

import org.example.mvc.model.User;
import org.example.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET /api/users - List all users
    @GetMapping
    public List<User> listUsers() {
        return userService.getAllUsers();
    }

    // GET /api/users/{id} - Get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(user);
    }

    // POST /api/users - Add a new user
    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
