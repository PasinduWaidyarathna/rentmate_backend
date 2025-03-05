package com.example.rentmate_backend.controller;

import com.example.rentmate_backend.model.Item;
import com.example.rentmate_backend.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin(origins = "*")
@Tag(name="ItemController",description="To perform operations on Items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Create a new Item
    @Operation(
            summary = "POST operation on Items",
            description = "It is used to save Item object in database"
    )
    @PostMapping
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item createdItem = itemService.createItem(item);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    // Get all Items
    @Operation(
            summary = "GET operation on Items",
            description = "Endpoint to fetch a list of all Items from the database"
    )
    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // Get Item by ID
    @Operation(
            summary = "GET - Find Item by ID",
            description = "Endpoint to retrieve a specific Item using their unique identifier"
    )
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Item> getItemById(@PathVariable String id) {
        Item item = itemService.getItemById(id);
        if (item == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    // Update Item
    @Operation(
            summary = "PUT operation on Item",
            description = "Endpoint to update an existing Item's details using their ID"
    )
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Item> updateItem(@PathVariable String id, @RequestBody Item item) {
        Item updatedItem = itemService.updateItem(id, item);
        if (updatedItem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    // Delete Item by ID
    @Operation(
            summary = "DELETE operation on Item",
            description = "Endpoint to remove a specific Item from the database using their unique identifier"
    )
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Void> deleteItem(@PathVariable String id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
