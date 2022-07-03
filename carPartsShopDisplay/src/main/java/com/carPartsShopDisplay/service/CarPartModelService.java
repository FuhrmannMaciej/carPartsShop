package com.carPartsShopDisplay.service;

import com.carPartsShopDisplay.entity.CarPartModel;

import java.util.Collection;

public interface CarPartModelService {

    Collection<CarPartModel> getAllCarPartModels();

    CarPartModel saveOrUpdateCarPartModel(CarPartModel carPartModel);

}
