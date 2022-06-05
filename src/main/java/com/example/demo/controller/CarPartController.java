package com.example.demo.controller;

import com.example.demo.entity.CarPart;
import com.example.demo.service.CarPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CarPartController {

    @Autowired
    private CarPartService carPartService;

    @GetMapping("/car-parts")
    public Collection<CarPart> getAllCarParts() {
        return carPartService.getAllCarParts();
    }

    @GetMapping("/car-parts/{id}")
    public CarPart getCarPartById(Long id) {
        return carPartService.getCarPartById(id);
    }

    @GetMapping("/car-parts/{name}")
    public CarPart getCarPartByName(String name) {
        return carPartService.getCarPartByName(name);
    }

    @PostMapping("/car-parts")
    public CarPart saveCarPart(CarPart carPart) {
        return carPartService.saveCarPart(carPart);
    }

    @PutMapping("/car-parts/{id}")
    public CarPart updateCarPart(CarPart carPart, Long id) {
        return carPartService.updateCarPart(carPart, id);
    }

    @DeleteMapping("/car-parts/{id}")
    public void deleteCarPart(Long id) {
        carPartService.deleteCarPart(id);
    }
}
