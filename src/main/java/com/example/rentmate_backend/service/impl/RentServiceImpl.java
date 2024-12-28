package com.example.rentmate_backend.service.impl;

import com.example.rentmate_backend.exceptions.rent.RentException;
import com.example.rentmate_backend.model.Rent;
import com.example.rentmate_backend.repository.RentRepository;
import com.example.rentmate_backend.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepository rentRepository;

    @Override
    public Rent createRent(Rent rent) {
        rent.setCreatedAt(new Date()); // Manually set createdAt
        rent.setUpdatedAt(new Date()); // Initial updatedAt
        return rentRepository.save(rent);
    }

    @Override
    public Rent getRentById(String id) {
        Optional<Rent> rent= rentRepository.findById(id);
        return rent.orElse(null); // Return null or throw an exception if not found
    }

    @Override
    public List<Rent> getAllRents() {
        return rentRepository.findAll();
    }

    @Override
    public Rent updateRent(String id, Rent updatedRent) {

        Optional<Rent> existingRent = rentRepository.findById(id);
        if (existingRent.isPresent()) {
            // Map the updated properties from the incoming Rent object
            Rent upCtd= existingRent.get();
            // Preserve the original createdAt
            updatedRent.setCreatedAt(upCtd.getCreatedAt());

            // Update updatedAt
            updatedRent.setUpdatedAt(new Date());
            upCtd.setStartDate(updatedRent.getStartDate());
            upCtd.setEndDate(updatedRent.getEndDate());
            upCtd.setBillingDetails(updatedRent.getBillingDetails());
            upCtd.setItemReturnedDate(updatedRent.getItemReturnedDate());
            upCtd.setOverDueFee(updatedRent.getOverDueFee());
            upCtd.setUpdatedAt(new Date());
            // Update other properties as needed
            return rentRepository.save(upCtd);
        } else {
            throw new RentException("Rent with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteRent(String id) {
        rentRepository.deleteById(id);
    }

}
