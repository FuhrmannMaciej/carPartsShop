package com.example.demo.service;

import com.example.demo.entity.CarPart;

import java.util.Collection;

public interface CarPartService {

    Collection<CarPart> getAllCarParts();

    CarPart getCarPartById(Long id);

    CarPart saveCarPart(CarPart carPart);

    CarPart updateCarPart(CarPart carPart, Long id);

    void deleteCarPart(Long id);

    CarPart getCarPartByName(String name);
}
