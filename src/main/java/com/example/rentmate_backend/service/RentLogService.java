package com.example.rentmate_backend.service;

import com.example.rentmate_backend.model.RentLog;
import java.util.List;
public interface RentLogService {
    RentLog createRentLog(RentLog rentlog);
    RentLog getRentLogById(String id);
    List<RentLog> getAllRentLogs();
    RentLog updateRentLog(String id, RentLog rentlog);
    void deleteRentLog(String id);

}
