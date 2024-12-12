package com.example.rentmate_backend.service.impl;

import com.example.rentmate_backend.exceptions.category.CategoryException;
import com.example.rentmate_backend.model.Category;
import com.example.rentmate_backend.repository.CategoryRepository;
import com.example.rentmate_backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null); // Return null or throw an exception if not found
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(String id, Category updatedCategory) {
        /*if (studentRepository.existsById(id)) {
            return studentRepository.save(student);
        }
        return null; // Return null or throw an exception if not found*/
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            // Map the updated properties from the incoming Category object
            Category upCtd= existingCategory.get();
            upCtd.setName(updatedCategory.getName());
            upCtd.setDescription(updatedCategory.getDescription());
            upCtd.setImageUrl(updatedCategory.getImageUrl());
            upCtd.setItemCount(updatedCategory.getItemCount());


            // Update other properties as needed
            return categoryRepository.save(upCtd);
        } else {
           throw new CategoryException("Category with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteCategory(String id) {
        categoryRepository.deleteById(id);
    }

}