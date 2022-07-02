package com.carPartsShop.service;

import com.carPartsShop.entity.CarPartModel;

import java.util.Collection;

public interface CarPartModelService {

    Collection<CarPartModel> getAllCarPartModels();

    CarPartModel saveOrUpdateCarPartModel(CarPartModel carPartModel);

}
