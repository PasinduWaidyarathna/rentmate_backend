package com.example.rentmate_backend.repository;

import com.example.rentmate_backend.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {

}
