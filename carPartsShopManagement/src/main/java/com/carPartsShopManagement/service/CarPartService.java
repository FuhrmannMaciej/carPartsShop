package com.carPartsShopManagement.service;

import com.carPartsShopManagement.entity.CarPart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Optional;

public interface CarPartService {

    Collection<CarPart> getAllCarParts();
    Page<CarPart> getAllCarParts(Pageable pageable);

    Optional<CarPart> getCarPartById(Long id);

    CarPart saveCarPart(CarPart carPart, Long carModelId);

    void updateCarPart(CarPart carPart, Long id);

    void deleteCarPart(Long id);

    Collection<CarPart> getCarPartByName(String name);

    void addCarPartToCarModel(Long carPartId, Long carModelId);
}
