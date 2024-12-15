package com.example.rentmate_backend.service;

import com.example.rentmate_backend.model.Category;
import com.example.rentmate_backend.model.Item;

import java.util.List;

public interface ItemService {
    Item createItem(Item item);
    Item getItemById(String id);
    List<Item> getAllItems();
    Item updateItem(String id, Item item);
    void deleteItem(String id);
}
