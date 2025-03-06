package com.example.rentmate_backend.model;

public enum RentStatus {
    RESERVED, // Item is reserved for the customer
    PAID, // Item is reserved and payment is completed
    OUT_FOR_DELIVERY, // Item is on the way to the customer
    WITH_CUSTOMER, // Customer has received the item and is using it
    RETURNED, // Item has been returned by the customer
    CANCELED; // Reservation or order has been canceled
}
