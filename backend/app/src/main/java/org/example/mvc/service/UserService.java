package org.example.mvc.service;

import org.example.mvc.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public UserService() {
        // Initial data
        users.add(new User(1, "John Doe", "john@example.com"));
        users.add(new User(2, "Jane Doe", "jane@example.com"));
    }

    // Retrieve all users
    public List<User> getAllUsers() {
        return users;
    }

    // Retrieve a user by ID
    public User getUserById(int id) {
        return users.stream()
            .filter(user -> user.getId() == id)
            .findFirst()
            .orElse(null);
    }

    // Add a new user
    public void addUser(User user) {
        users.add(user);
    }
}
