package com.carPartsShop.service;

import com.carPartsShop.entity.CarModel;
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

    Collection<CarModel> getCarModelByName(String name);

    Collection<CarModel> getCarModelByYearOfProduction(int yearOfProduction);
}
