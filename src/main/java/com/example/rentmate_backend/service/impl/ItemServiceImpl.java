package com.example.rentmate_backend.service.impl;

import com.example.rentmate_backend.exceptions.item.ItemException;
import com.example.rentmate_backend.model.Item;
import com.example.rentmate_backend.repository.ItemRepository;
import com.example.rentmate_backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item getItemById(String id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.orElse(null); // Return null or throw an exception if not found
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item updateItem(String id, Item updatedItem) {
        /*if (studentRepository.existsById(id)) {
            return studentRepository.save(student);
        }
        return null; // Return null or throw an exception if not found*/
        Optional<Item> existingItem = itemRepository.findById(id);
        if (existingItem.isPresent()) {
            // Map the updated properties from the incoming Item object
            Item updateItem = existingItem.get();
            updateItem.setName(updatedItem.getName());
            updateItem.setDescription(updatedItem.getDescription());
            updateItem.setCategoryId(updatedItem.getCategoryId());

            updateItem.setTotalQuantity(updatedItem.getTotalQuantity());
            updateItem.setAvailableQuantity(updatedItem.getAvailableQuantity());
            updateItem.setReservedQuantity(updatedItem.getReservedQuantity());
            updateItem.setRentedQuantity(updatedItem.getRentedQuantity());

            // Deep copy pricing details
            updateItem.setPricing(new ArrayList<>(updatedItem.getPricing()));

            // Deep copy image URLs
            updateItem.setImageUrls(new ArrayList<>(updatedItem.getImageUrls()));

            // Deep copy delivery options
            updateItem.setDeliveryOptions(new ArrayList<>(updatedItem.getDeliveryOptions()));

            // Update other properties as needed
            return itemRepository.save(updateItem);
        } else {
            throw new ItemException("Item with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }
}
