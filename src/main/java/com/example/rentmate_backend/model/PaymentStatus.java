package com.example.rentmate_backend.model;

public enum PaymentStatus {
    PENDING, // Payment is yet to be made or processed
    SUCCESS, // Payment has been successfully completed
    FAILED, // Payment attempt was unsuccessful
    CANCELED, // Payment process was canceled by the user or system
    REFUNDED; // Payment was refunded to the customer
}
