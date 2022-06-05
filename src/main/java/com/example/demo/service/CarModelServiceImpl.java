package com.example.demo.service;

import com.example.demo.entity.CarModel;
import com.example.demo.entity.User;
import com.example.demo.repository.CarModelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Objects;

public class CarModelServiceImpl implements CarModelService {

    @Autowired
    private CarModelRepository carModelRepository;

    @Override
    public Collection<CarModel> getAllCarModels() {
        return carModelRepository.findAll();
    }

    @Override
    public CarModel getCarModelById(Long id) {
        return carModelRepository.findById(id).orElse(null);
    }

    @Override
    public CarModel saveCarModel(CarModel carModel) {
        return carModelRepository.save(carModel);
    }

    @Override
    public CarModel updateCarModel(CarModel carModel, Long id) {
        CarModel carModelDB = carModelRepository.findById(id).get();

        if (Objects.nonNull(carModel.getName()) && !carModel.getName().isEmpty()) {
            carModelDB.setName(carModel.getName());
        }

        if (Objects.nonNull(carModel.getYearOfProduction())) {
            carModelDB.setYearOfProduction(carModel.getYearOfProduction());
        }

        return carModelRepository.save(carModelDB);
    }

    @Override
    public void deleteCarModel(Long id) {
        carModelRepository.deleteById(id);
    }

    @Override
    public CarModel getCarModelByName(String name) {
        return carModelRepository.findByName(name);
    }

    @Override
    public CarModel getCarModelByYearOfProduction(int yearOfProduction) {
        return carModelRepository.findByYearOfProduction(yearOfProduction);
    }
}
