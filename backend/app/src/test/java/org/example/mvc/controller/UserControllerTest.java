package org.example.mvc.controller;

import org.example.mvc.model.User;
import org.example.mvc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void listUsers_shouldReturnAllUsers() throws Exception {
        when(userService.getAllUsers()).thenReturn(
            Arrays.asList(
                new User(1, "John Doe", "john@example.com"),
                new User(2, "Jane Doe", "jane@example.com")
            )
        );

        mockMvc.perform(get("/api/v2/users"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].name").value("John Doe"))
            .andExpect(jsonPath("$[1].name").value("Jane Doe"));

        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void getUserById_existingUser_shouldReturnUser() throws Exception {
        when(userService.getUserById(1)).thenReturn(
            new User(1, "John Doe", "john@example.com")
        );

        mockMvc.perform(get("/api/v2/users/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name").value("John Doe"));

        verify(userService, times(1)).getUserById(1);
    }

    @Test
    void getUserById_nonExistingUser_shouldReturn404() throws Exception {
        when(userService.getUserById(999)).thenReturn(null);

        mockMvc.perform(get("/api/v2/users/999"))
            .andExpect(status().isNotFound());

        verify(userService, times(1)).getUserById(999);
    }
}
