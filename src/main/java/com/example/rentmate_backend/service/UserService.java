package com.example.rentmate_backend.service;

import com.example.rentmate_backend.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(String id);
    List<User> getAllUsers();
    User updateUser(String id, User user);
    void deleteUser(String id);
    List<User> getUsersByRole(String role);
    User getUserBySid(String sid);
    String getUserIdBySid(String sid);
    User getUserByEmail(String email);
}
