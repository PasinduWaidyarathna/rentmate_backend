package com.example.rentmate_backend.controller;

import com.example.rentmate_backend.model.User;
import com.example.rentmate_backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@Tag(name="UserController",description="To perform operations on Users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new User
    @Operation(
            summary = "POST operation on Users",
            description = "It is used to save User object in database"
    )
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Get all Users
    @Operation(
            summary = "GET operation on Users",
            description = "Endpoint to fetch a list of all Users from the database"
    )
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Get User by ID
    @Operation(
            summary = "GET - Find User by ID",
            description = "Endpoint to retrieve a specific User using their unique identifier"
    )
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Update User
    @Operation(
            summary = "PUT operation on User",
            description = "Endpoint to update an existing User's details using their ID"
    )
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Delete User by ID
    @Operation(
            summary = "DELETE operation on User",
            description = "Endpoint to remove a specific User from the database using their unique identifier"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
