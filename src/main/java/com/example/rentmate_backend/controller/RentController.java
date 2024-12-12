package com.example.rentmate_backend.controller;

import com.example.rentmate_backend.model.Rent;
import com.example.rentmate_backend.service.RentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rent")
@Tag(name="RentController",description="To perform operations on Categories")
public class RentController {

    @Autowired
    private RentService rentService;

    // Create a new Rent
    @Operation(
            summary = "POST operation on Categories",
            description = "It is used to save Rent object in database"
    )
    @PostMapping
    public ResponseEntity<Rent> createRent(@RequestBody Rent rent) {
        Rent createdRent = rentService.createRent(rent);
        return new ResponseEntity<>(createdRent, HttpStatus.CREATED);
    }

    // Get all Rents
    @Operation(
            summary = "GET operation on Categories",
            description = "Endpoint to fetch a list of all Categories from the database"
    )
    @GetMapping
    public ResponseEntity<List<Rent>> getAllCategories() {
        List<Rent> categories = rentService.getAllRents();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // Get Rent by ID
    @Operation(
            summary = "GET - Find Rent by ID",
            description = "Endpoint to retrieve a specific Rent using their unique identifier"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Rent> getRentById(@PathVariable String id) {
        Rent rent = rentService.getRentById(id);
        if (rent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rent, HttpStatus.OK);
    }

    // Update Rent
    @Operation(
            summary = "PUT operation on Rent",
            description = "Endpoint to update an existing rent's details using their ID"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Rent> updateRent(@PathVariable String id, @RequestBody Rent rent) {
        Rent updatedRent = rentService.updateRent(id, rent);
        if (updatedRent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedRent, HttpStatus.OK);
    }

    // Delete Rent by ID
    @Operation(
            summary = "DELETE operation on Rent",
            description = "Endpoint to remove a specific Rent from the database using their unique identifier"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRent(@PathVariable String id) {
        rentService.deleteRent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
