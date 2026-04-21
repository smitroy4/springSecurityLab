package com.smit.springSecurity.service;

import com.smit.springSecurity.entity.Laptop;
import com.smit.springSecurity.repository.LaptopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaptopService {

    private final LaptopRepository laptopRepository;

    public Laptop addLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public Laptop getLaptopById(Long id) {
        return laptopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Laptop not found"));
    }

    public void deleteLaptop(Long id) {
        laptopRepository.deleteById(id);
    }
}