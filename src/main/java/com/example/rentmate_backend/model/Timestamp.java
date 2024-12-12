package com.example.rentmate_backend.model;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Timestamp {
    private Date createdAt;
    private Date updatedAt;
}
