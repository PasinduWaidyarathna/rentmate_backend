package com.example.rentmate_backend.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

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
    @CreatedDate
    @Field("created_at")
    private Date createdAt;

    @LastModifiedDate
    @Field("updated_at")
    private Date updatedAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLenderId() {
        return lenderId;
    }

    public void setLenderId(String lenderId) {
        this.lenderId = lenderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public LocalDateTime getItemReturnedDate() {
        return itemReturnedDate;
    }

    public void setItemReturnedDate(LocalDateTime itemReturnedDate) {
        this.itemReturnedDate = itemReturnedDate;
    }

    public Double getOverDueFee() {
        return overDueFee;
    }

    public void setOverDueFee(Double overDueFee) {
        this.overDueFee = overDueFee;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


