package com.example.demo.controller;

import com.example.demo.entity.CarPart;
import com.example.demo.service.CarPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class CarPartController {

    //TODO: dodaj opcje dodawania i usuwania części/modeli samochodów
    //TODO: rozdzielić projekt na mikroserwisy ten z dodawaniem i usuwaniem, drugi z wyświetlaniem/szukaniem (zrobić jeden model z carModel i carPart)
    //TODO: konfiguracja kolejkowania w Kafka lub RabbitMQ
    //TODO: Docker

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
