package com.example.rentmate_backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping
    public Object hello() {
        Map<String, String> object = new HashMap<>();
        object.put("name", "Integrati Ninjas Pasindu");
        object.put("email", "integrationninjas@gmail.com");
        return object;
    }

}

