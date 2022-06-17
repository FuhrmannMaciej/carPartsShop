package com.example.demo.service;

import com.example.demo.entity.CarModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface CarModelService {

    Page<CarModel> getAllCarModels(Pageable pageable);

    Collection<CarModel> getAllCarModels();

    CarModel getCarModelById(Long id);

    CarModel saveCarModel(CarModel carModel);

    CarModel updateCarModel(CarModel carModel, Long id);

    void deleteCarModel(Long id);

    CarModel getCarModelByName(String name);

    CarModel getCarModelByYearOfProduction(int yearOfProduction);
}
