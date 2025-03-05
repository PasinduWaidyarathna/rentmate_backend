package com.example.rentmate_backend.controller;

import com.example.rentmate_backend.model.RentLog;
import com.example.rentmate_backend.service.RentLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rentlog")
@CrossOrigin(origins = "*")
@Tag(name="RentLogController",description="To perform operations on RentLog")
public class RentLogController {

    @Autowired
    private RentLogService rentlogService;

    // Create a new RentLog
    @Operation(
            summary = "POST operation on RentLog",
            description = "It is used to save RentLog object in database"
    )
    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<RentLog> createRentLog(@RequestBody RentLog rentlog) {
        RentLog createdRentLog = rentlogService.createRentLog(rentlog);
        return new ResponseEntity<>(createdRentLog, HttpStatus.CREATED);
    }

    // Get all RentLogs
    @Operation(
            summary = "GET operation on RentLog",
            description = "Endpoint to fetch a list of all RentLog from the database"
    )
    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<RentLog>> getAllRentLogs() {
        List<RentLog> rentLog = rentlogService.getAllRentLogs();
        return new ResponseEntity<>(rentLog, HttpStatus.OK);
    }

    // Get RentLog by ID
    @Operation(
            summary = "GET - Find RentLog by ID",
            description = "Endpoint to retrieve a specific RentLog using their unique identifier"
    )
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<RentLog> getRentLogById(@PathVariable String id) {
        RentLog rentlog = rentlogService.getRentLogById(id);
        if (rentlog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rentlog, HttpStatus.OK);
    }

    // Update RentLog
    @Operation(
            summary = "PUT operation on RentLog",
            description = "Endpoint to update an existing rentlog's details using their ID"
    )
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<RentLog> updateRentLog(@PathVariable String id, @RequestBody RentLog rentlog) {
        RentLog updatedRentLog = rentlogService.updateRentLog(id, rentlog);
        if (updatedRentLog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedRentLog, HttpStatus.OK);
    }

    // Delete RentLog by ID
    @Operation(
            summary = "DELETE operation on RentLog",
            description = "Endpoint to remove a specific RentLog from the database using their unique identifier"
    )
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Void> deleteRentLog(@PathVariable String id) {
        rentlogService.deleteRentLog(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
