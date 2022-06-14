package com.example.demo.controller;

import com.example.demo.entity.CarModel;
import com.example.demo.entity.CarPart;
import com.example.demo.service.CarModelService;
import com.example.demo.service.CarPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class CarPartController {

    //TODO: dodaj opcje dodawania i usuwania części/modeli samochodów
    //TODO: rozdzielić projekt na mikroserwisy ten z dodawaniem i usuwaniem, drugi z wyświetlaniem/szukaniem (zrobić jeden model z carModel i carPart)
    //TODO: konfiguracja kolejkowania w Kafka lub RabbitMQ
    //TODO: Docker

    @Autowired
    private CarPartService carPartService;

    @Autowired
    private CarModelService carModelService;

    @GetMapping("/api/car-parts")
    @ResponseBody
    public Collection<CarPart> getAllCarParts() {
        return carPartService.getAllCarParts();
    }

    @GetMapping("/api/car-parts/{id}")
    @ResponseBody
    public CarPart getCarPartById(Long id) {
        return carPartService.getCarPartById(id);
    }

    @PostMapping("/api/car-parts")
    @ResponseBody
    public CarPart saveCarPart(CarPart carPart) {
        return carPartService.saveCarPart(carPart);
    }

    @PutMapping("/api/car-parts/{id}")
    @ResponseBody
    public CarPart updateCarPart(CarPart carPart, Long id) {
        return carPartService.updateCarPart(carPart, id);
    }

    @DeleteMapping("/api/car-parts/{id}")
    @ResponseBody
    public void deleteCarPart(Long id) {
        carPartService.deleteCarPart(id);
    }

    @GetMapping("/add-car-part")
    public String showAddCarPartForm(Model model) {
        model.addAttribute("car_models", carModelService.getAllCarModels());
        return "add-car-part";
    }

    @PostMapping("/add-car-part")
    public String saveCarPart(@Valid CarPart carPart, BindingResult result) {
        if (result.hasErrors()) {
            return "add-car-part";
        }
        carPartService.saveCarPart(carPart);
        return "redirect:/";
    }
}
