package com.carPartsShop.controller;

import com.carPartsShop.entity.CarPartModel;
import com.carPartsShop.service.CarPartModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class CarPartModelController {

    @Autowired
    private CarPartModelService carPartModelService;

    @GetMapping("/carPartModels")
    public String getAllCarPartModels() {
        return "carPartModels";
    }

    @GetMapping("/api/carPartModels")
    @ResponseBody
    public Collection<CarPartModel> getAllCarModels() {
        return carPartModelService.getAllCarPartModels();
    }
}
