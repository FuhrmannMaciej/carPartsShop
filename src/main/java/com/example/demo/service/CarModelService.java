package com.example.demo.service;

import com.example.demo.entity.CarModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Optional;

public interface CarModelService {

    Page<CarModel> getAllCarModels(Pageable pageable);

    Collection<CarModel> getAllCarModels();

    Optional<CarModel> getCarModelById(Long id);

    CarModel saveCarModel(CarModel carModel);

    void updateCarModel(CarModel carModel, Long id);

    void deleteCarModel(Long id);

    Optional<CarModel> getCarModelByName(String name);

    Optional<CarModel> getCarModelByYearOfProduction(int yearOfProduction);
}
