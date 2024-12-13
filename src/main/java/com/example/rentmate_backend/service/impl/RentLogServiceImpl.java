package com.example.rentmate_backend.service.impl;

import com.example.rentmate_backend.exceptions.rentlog.RentLogException;
import com.example.rentmate_backend.model.RentLog;
import com.example.rentmate_backend.repository.RentLogRepository;
import com.example.rentmate_backend.service.RentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RentLogServiceImpl implements RentLogService {

    @Autowired
    private RentLogRepository rentlogRepository;

    @Override
    public RentLog createRentLog(RentLog rentlog) {
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
        /*if (studentRepository.existsById(id)) {
            return studentRepository.save(student);
        }
        return null; // Return null or throw an exception if not found*/
        Optional<RentLog> existingRentLog = rentlogRepository.findById(id);
        if (existingRentLog.isPresent()) {
            // Map the updated properties from the incoming RentLog object
            RentLog upCtd= existingRentLog.get();
            upCtd.setItemId(updatedRentLog.getItemId());


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