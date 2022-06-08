package com.example.demo.controller;

import com.example.demo.entity.CarModel;
import com.example.demo.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CarModelController {

    @Autowired
    private CarModelService carModelService;

    @GetMapping("/car-models")
    public Page<CarModel> getAllCarModels(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return carModelService.getAllCarModels(pageRequest);
    }

    @GetMapping("/car-models/{id}")
    public CarModel getCarModelById(Long id) {
        return carModelService.getCarModelById(id);
    }

    @GetMapping("/car-models/{name}")
    public CarModel getCarModelByName(String name) {
        return carModelService.getCarModelByName(name);
    }

    @GetMapping("/car-models/{yearOfProduction}")
    public CarModel getCarModelByYearOfProduction(int yearOfProduction) {
        return carModelService.getCarModelByYearOfProduction(yearOfProduction);
    }

    @PostMapping("/car-models")
    public CarModel saveCarModel(CarModel carModel) {
        return carModelService.saveCarModel(carModel);
    }

    @PutMapping("/car-models/{id}")
    public CarModel updateCarModel(CarModel carModel, Long id) {
        return carModelService.updateCarModel(carModel, id);
    }

    @DeleteMapping("/car-models/{id}")
    public void deleteCarModel(Long id) {
        carModelService.deleteCarModel(id);
    }
}
