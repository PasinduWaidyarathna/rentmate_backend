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
public class Rent {
    @Id
    private String id;

    private String userId; // Customer ID
    private String lenderId; // Lender ID (owner of the item)
    private String itemId; // ID of the rented item
    private LocalDateTime startDate; // Rental start date
    private LocalDateTime endDate; // Rental end date
    //private DeliveryOptions deliveryOption;
    private double itemCost; // Cost per item
    private double totalCost; // Total cost of the rental (including fees, etc.)
    //private PaymentStatus paymentStatus; // Current payment status
    //private RentStatus rentStatus; // Current rental status
    private LocalDateTime itemReturnedDate; // Date the item was returned (optional)
    private Double overDueFee; // Fee for overdue returns (optional)
    private int quantity; // Number of items rented
    private Timestamp timestamp;

}


