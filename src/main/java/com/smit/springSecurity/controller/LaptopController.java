package com.smit.springSecurity.controller;

import com.smit.springSecurity.entity.Laptop;
import com.smit.springSecurity.service.LaptopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laptops")
@RequiredArgsConstructor
public class LaptopController {

    private final LaptopService laptopService;

    @PostMapping
    public Laptop addLaptop(@RequestBody Laptop laptop) {
        return laptopService.addLaptop(laptop);
    }

    @GetMapping
    public List<Laptop> getAllLaptops() {
        return laptopService.getAllLaptops();
    }

    @GetMapping("/{id}")
    public Laptop getLaptopById(@PathVariable Long id) {
        return laptopService.getLaptopById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteLaptop(@PathVariable Long id) {
        laptopService.deleteLaptop(id);
        return "Laptop deleted successfully";
    }
}