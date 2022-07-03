package com.carPartsShop.controller;

import com.carPartsShop.entity.CarPart;
import com.carPartsShop.service.CarPartService;
import com.carPartsShop.web.dto.CarPartToCarModelDto;
import com.carPartsShop.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

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
    public Page<CarPart> getAllCarParts(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
            Pageable pageRequest = PageRequest.of(page-1, size, Sort.by(Sort.Order.asc("id"), Sort.Order.desc("name")));
        return carPartService.getAllCarParts(pageRequest);
    }

    @GetMapping("/api/car-parts/{id}")
    @ResponseBody
    public Optional<CarPart> getCarPartById(@PathVariable Long id) {
        return carPartService.getCarPartById(id);
    }

    @GetMapping("/api/car-parts-by-name")
    @ResponseBody
    public Collection<CarPart> getCarPartByName(@RequestParam String name) {
        return carPartService.getCarPartByName(name);
    }

    @PostMapping("/api/car-parts")
    @ResponseBody
    public CarPart saveCarPart(@Valid @RequestBody CarPart carPart, @RequestBody Long carModelId) {
        return carPartService.saveCarPart(carPart, carModelId);
    }

    @PutMapping("/api/car-parts/{id}")
    @ResponseBody
    public void  updateCarPart(@Valid @RequestBody CarPart carPart, @PathVariable Long id) {
        carPartService.updateCarPart(carPart, id);
    }

    @DeleteMapping("/api/car-parts/{id}")
    @ResponseBody
    public void deleteCarPart(@PathVariable Long id) {
        carPartService.deleteCarPart(id);
    }

    @GetMapping("/add-car-part")
    public String showAddCarPartForm(Model model) {
        model.addAttribute("car_models", carModelService.getAllCarModels());
        return "add-car-part";
    }

    @PostMapping("/add-car-part")
    public String saveCarPart(@Valid CarPart carPart, @Valid Long carModelId, BindingResult result) {
        if (result.hasErrors()) {
            return "add-car-part";
        }
        carPartService.saveCarPart(carPart, carModelId);
        return "redirect:/";
    }
    @GetMapping("/add-car-part-to-car-model")
    public String showAddCarPartToCarModelForm(Model model) {
        model.addAttribute("car_models", carModelService.getAllCarModels());
        model.addAttribute("car_parts", carPartService.getAllCarParts());
        return "add-car-part-to-car-model";
    }

    @PostMapping( value = "/add-car-part-to-car-model")
    public String addCarPartToCarModel(@Valid CarPartToCarModelDto carPartToCarModelDto, BindingResult result) {
        if (result.hasErrors()) {
            return "add-car-part-to-car-model";
        }
        carPartService.addCarPartToCarModel(carPartToCarModelDto.getCarPartId(), carPartToCarModelDto.getCarModelId());
        return "redirect:/";
    }
}
