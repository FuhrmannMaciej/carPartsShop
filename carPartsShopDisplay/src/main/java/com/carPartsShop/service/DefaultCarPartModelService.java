package com.carPartsShop.service;

import com.carPartsShop.entity.CarPartModel;
import com.carPartsShop.repository.CarPartModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DefaultCarPartModelService implements CarPartModelService {

    @Autowired
    private CarPartModelRepository carPartModelRepository;

    @Override
    public Collection<CarPartModel> getAllCarPartModels() {
        return carPartModelRepository.findAll();
    }

    @Override
    public CarPartModel saveCarPartModel(CarPartModel carPartModel) {
        return carPartModelRepository.save(carPartModel);
    }
}
