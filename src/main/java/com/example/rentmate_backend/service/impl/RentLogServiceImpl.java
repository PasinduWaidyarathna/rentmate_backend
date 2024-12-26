package com.example.rentmate_backend.service.impl;

import com.example.rentmate_backend.exceptions.rentlog.RentLogException;
import com.example.rentmate_backend.model.RentLog;
import com.example.rentmate_backend.repository.RentLogRepository;
import com.example.rentmate_backend.service.RentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RentLogServiceImpl implements RentLogService {

    @Autowired
    private RentLogRepository rentlogRepository;

    @Override
    public RentLog createRentLog(RentLog rentlog) {
        rentlog.setCreatedAt(new Date()); // Manually set createdAt
        rentlog.setUpdatedAt(new Date()); // Initial updatedAt
        return rentlogRepository.save(rentlog);
    }

    @Override
    public RentLog getRentLogById(String id) {
        Optional<RentLog> rentlog = rentlogRepository.findById(id);
        return rentlog.orElse(null); // Return null or throw an exception if not found
    }

    @Override
    public List<RentLog> getAllRentLogs() {
        return rentlogRepository.findAll();
    }

    @Override
    public RentLog updateRentLog(String id, RentLog updatedRentLog) {

        Optional<RentLog> existingRentLog = rentlogRepository.findById(id);
        if (existingRentLog.isPresent()) {
            // Map the updated properties from the incoming RentLog object
            RentLog upCtd= existingRentLog.get();
            // Preserve the original createdAt
            updatedRentLog.setCreatedAt(upCtd.getCreatedAt());

            // Update updatedAt
            updatedRentLog.setUpdatedAt(new Date());
            upCtd.setItemId(updatedRentLog.getItemId());
            upCtd.setUpdatedAt(new Date());
            // Update other properties as needed
            return rentlogRepository.save(upCtd);
        } else {
            throw new RentLogException("RentLog with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteRentLog(String id) {
        rentlogRepository.deleteById(id);
    }

}