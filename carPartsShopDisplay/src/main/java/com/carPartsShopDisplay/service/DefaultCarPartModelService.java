package com.carPartsShopDisplay.service;

import com.carPartsShopDisplay.entity.CarPartModel;
import com.carPartsShopDisplay.repository.CarPartModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Slf4j
@Service
public class DefaultCarPartModelService implements CarPartModelService {

    @Autowired
    private CarPartModelRepository carPartModelRepository;

    @Override
    public Collection<CarPartModel> getAllCarPartModels() {
        return carPartModelRepository.findAll();
    }

    @Override
    public CarPartModel saveOrUpdateCarPartModel(CarPartModel carPartModel) {
        Optional<CarPartModel> existingCarPartModel = carPartModelRepository.findByCarPartSourceSystemIdAndCarModelSourceSystemId(carPartModel.getCarPartSourceSystemId(), carPartModel.getCarModelSourceSystemId());
        if (existingCarPartModel.isPresent()) {
            log.info("Updating car part model with id: {}", existingCarPartModel.get().getId());
            CarPartModel carPartModelFromDb = existingCarPartModel.get();
            carPartModelFromDb.setCarPartSourceSystemId(carPartModel.getCarPartSourceSystemId());
            carPartModelFromDb.setCarModelSourceSystemId(carPartModel.getCarModelSourceSystemId());
            carPartModelFromDb.setCarModelName(carPartModel.getCarModelName());
            carPartModelFromDb.setCarPartName(carPartModel.getCarPartName());
            carPartModelFromDb.setYearOfProduction(carPartModel.getYearOfProduction());
            carPartModelFromDb.setPrice(carPartModel.getPrice());
            carPartModelFromDb.setQuantity(carPartModel.getQuantity());
            return carPartModelRepository.save(carPartModelFromDb);
        } else {
            log.info("Saving car part model with carPartId: {}, carModelId: {}", carPartModel.getCarPartSourceSystemId(), carPartModel.getCarModelSourceSystemId());
            return carPartModelRepository.save(carPartModel);
        }

    }
}
