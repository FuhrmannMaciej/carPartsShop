package com.example.demo.service;

import com.example.demo.entity.CarModel;
import com.example.demo.entity.User;
import com.example.demo.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.List;

public interface CarModelService {

    Collection<CarModel> getAllCarModels();

    CarModel getCarModelById(Long id);

    CarModel saveCarModel(CarModel carModel);

    CarModel updateCarModel(CarModel carModel, Long id);

    void deleteCarModel(Long id);

    CarModel getCarModelByName(String name);

    CarModel getCarModelByYearOfProduction(int yearOfProduction);
}
