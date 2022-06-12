package com.example.demo.service;

import com.example.demo.entity.CarPart;
import com.example.demo.repository.CarPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Service
public class DefaultCarPartService implements CarPartService {

    @Autowired
    private CarPartRepository carPartRepository;

    @Override
    public Collection<CarPart> getAllCarParts() {
        return carPartRepository.findAll();
    }

    @Override
    public CarPart getCarPartById(Long id) {
        return carPartRepository.findById(id).orElse(null);
    }

    @Override
    public CarPart saveCarPart(CarPart carPart) {
        return carPartRepository.save(carPart);
    }

    @Override
    public CarPart updateCarPart(CarPart carPart, Long id) {
        CarPart carPartDB = carPartRepository.findById(id).get();

        if (Objects.nonNull(carPartDB.getName()) && !carPartDB.getName().isEmpty()) {
            carPartDB.setName(carPartDB.getName());
        }

        if (Objects.nonNull(carPartDB.getPrice())) {
            carPartDB.setPrice(carPartDB.getPrice());
        }

        if (Objects.nonNull(carPartDB.getQuantity())) {
            carPartDB.setQuantity(carPartDB.getQuantity());
        }

        return carPartRepository.save(carPartDB);
    }

    @Override
    public void deleteCarPart(Long id) {
        carPartRepository.deleteById(id);
    }

    @Override
    public CarPart getCarPartByName(String name) {
        return carPartRepository.findByName(name);
    }
}
