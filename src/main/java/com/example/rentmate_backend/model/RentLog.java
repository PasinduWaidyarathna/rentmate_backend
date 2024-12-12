package com.example.rentmate_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Document(collection = "rent")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentLog {
    @Id
    private String id;

    private String itemId; // ID of the rented item
    private String rentRecordId; // rent record ID
    //private PaymentStatus paymentStatus; // Current payment status
    //private RentStatus rentStatus; // Current rental status
    private int quantity; // Number of items rented
    private LocalDateTime createdAt; // Record creation timestamp
    private LocalDateTime updatedAt; // Record update timestamp


}



