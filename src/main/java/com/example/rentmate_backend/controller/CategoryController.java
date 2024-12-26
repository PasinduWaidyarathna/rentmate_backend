package com.example.rentmate_backend.controller;

import com.example.rentmate_backend.model.Category;
import com.example.rentmate_backend.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
@CrossOrigin(origins = "*")
@Tag(name="CategoryController",description="To perform operations on Categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Create a new Category
    @Operation(
            summary = "POST operation on Categories",
            description = "It is used to save Category object in database"
    )
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    // Get all Categorys
    @Operation(
            summary = "GET operation on Categories",
            description = "Endpoint to fetch a list of all Categories from the database"
    )
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // Get Category by ID
    @Operation(
            summary = "GET - Find Category by ID",
            description = "Endpoint to retrieve a specific Category using their unique identifier"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable String id) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    // Update Category
    @Operation(
            summary = "PUT operation on Category",
            description = "Endpoint to update an existing category's details using their ID"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable String id, @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(id, category);
        if (updatedCategory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    // Delete Category by ID
    @Operation(
            summary = "DELETE operation on Category",
            description = "Endpoint to remove a specific Category from the database using their unique identifier"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
