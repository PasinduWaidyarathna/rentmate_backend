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

@Document(collection = "rentlogs")
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
    @CreatedDate
    @Field("created_at")
    private Date createdAt;

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @LastModifiedDate
    @Field("updated_at")
    private Date updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getRentRecordId() {
        return rentRecordId;
    }

    public void setRentRecordId(String rentRecordId) {
        this.rentRecordId = rentRecordId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}



