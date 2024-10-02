package org.example.mvc.service;

import org.example.mvc.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(); // Initialize before each test
    }

    @Test
    void getAllUsers_shouldReturnDefaultUsers() {
        List<User> users = userService.getAllUsers();
        assertEquals(2, users.size());
    }

    @Test
    void getUserById_existingId_shouldReturnUser() {
        User user = userService.getUserById(1);
        assertNotNull(user);
        assertEquals("John Doe", user.getName());
    }

    @Test
    void getUserById_nonExistingId_shouldReturnNull() {
        User user = userService.getUserById(999);
        assertNull(user);
    }

    @Test
    void addUser_shouldIncreaseUserListSize() {
        User newUser = new User(3, "Alice Johnson", "alice@example.com");
        userService.addUser(newUser);

        List<User> users = userService.getAllUsers();
        assertEquals(3, users.size());
    }
}
