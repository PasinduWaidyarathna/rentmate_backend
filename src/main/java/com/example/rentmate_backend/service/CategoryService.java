package com.example.rentmate_backend.service;

import com.example.rentmate_backend.model.Category;
import java.util.List;
public interface CategoryService {
    Category createCategory(Category category);
    Category getCategoryById(String id);
    List<Category> getAllCategories();
    Category updateCategory(String id, Category category);
    void deleteCategory(String id);

}
