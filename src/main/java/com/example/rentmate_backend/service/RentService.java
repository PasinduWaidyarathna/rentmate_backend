package com.example.rentmate_backend.service;

import com.example.rentmate_backend.model.Rent;
import java.util.List;
public interface RentService {
    Rent createRent(Rent rent);
    Rent getRentById(String id);
    List<Rent> getAllRents();
    Rent updateRent(String id, Rent rent);
    void deleteRent(String id);

}

