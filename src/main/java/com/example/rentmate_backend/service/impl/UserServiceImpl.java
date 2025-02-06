package com.example.rentmate_backend.service.impl;

import com.example.rentmate_backend.exceptions.user.UserException;
import com.example.rentmate_backend.model.User;
import com.example.rentmate_backend.repository.UserRepository;
import com.example.rentmate_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        user.setCreatedAt(new Date()); // Manually set createdAt
        user.setUpdatedAt(new Date()); // Initial updatedAt
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null); // Return null or throw an exception if not found
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    @Override
    public User updateUser(String id, User updatedUser) {

        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {

            User updateUser = existingUser.get();
            // Preserve the original createdAt
            updatedUser.setCreatedAt(updateUser.getCreatedAt());

            // Update updatedAt
            updatedUser.setUpdatedAt(new Date());
            updateUser.setFirstName(updatedUser.getFirstName());
            updateUser.setLastName(updatedUser.getLastName());
            updateUser.setRole(updatedUser.getRole());
            updateUser.setContactNo(updatedUser.getContactNo());
            updateUser.setIsBlackListed(updatedUser.getIsBlackListed());
            updateUser.setAddress(updatedUser.getAddress());
            updateUser.setZipCode(updatedUser.getZipCode());
            updateUser.setVerified(updatedUser.getVerified());
            updateUser.setNic(updatedUser.getNic());
            updateUser.setUpdatedAt(new Date());
            // Update other properties as needed
            return userRepository.save(updateUser);
        } else {
            throw new UserException("User with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
