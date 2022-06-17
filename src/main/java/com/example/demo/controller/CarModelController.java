package com.example.demo.controller;

import com.example.demo.entity.CarModel;
import com.example.demo.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CarModelController {

    @Autowired
    private CarModelService carModelService;

    @GetMapping("/api/car-models")
    @ResponseBody
    public Page<CarModel> getAllCarModels(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        Pageable pageRequest = PageRequest.of(page-1, size, Sort.by(Sort.Order.asc("id"), Sort.Order.desc("name")));
        return carModelService.getAllCarModels(pageRequest);
    }

    @GetMapping("/api/car-models/{id}")
    @ResponseBody
    public CarModel getCarModelById(Long id) {
        return carModelService.getCarModelById(id);
    }

    @PostMapping("/api/car-models")
    @ResponseBody
    public CarModel saveCarModel(@Valid @RequestBody CarModel carModel) {
        return carModelService.saveCarModel(carModel);
    }

    @PutMapping("/api/car-models/{id}")
    @ResponseBody
    public CarModel updateCarModel(CarModel carModel, Long id) {
        return carModelService.updateCarModel(carModel, id);
    }

    @DeleteMapping("/api/car-models/{id}")
    @ResponseBody
    public void deleteCarModel(Long id) {
        carModelService.deleteCarModel(id);
    }

    @GetMapping("/add-car-model")
    public String showAddCarModelForm() {
        return "add-car-model";
    }

    @PostMapping("/add-car-model")
    public String saveCarModel(@Valid CarModel carModel, BindingResult result) {
        if (result.hasErrors()) {
            return "add-car-model";
        }
        carModelService.saveCarModel(carModel);
        return "redirect:/";
    }
}
