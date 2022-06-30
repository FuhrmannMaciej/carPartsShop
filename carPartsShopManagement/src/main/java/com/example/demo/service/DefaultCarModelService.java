package com.example.demo.service;

import com.example.demo.entity.CarModel;
import com.example.demo.exception.CarModelNotFoundException;
import com.example.demo.repository.CarModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Service
public class DefaultCarModelService implements CarModelService {

    @Autowired
    private CarModelRepository carModelRepository;

    @Override
    public Page<CarModel> getAllCarModels(Pageable pageable) {
        return carModelRepository.findAll(pageable);
    }

    @Override
    public Collection<CarModel> getAllCarModels() {
        return carModelRepository.findAll();
    }

    @Override
    public Optional<CarModel> getCarModelById(Long id) {
        Optional<CarModel> carModelOptional = carModelRepository.findById(id);
        if (carModelOptional.isEmpty()) {
            throw new CarModelNotFoundException();
        }
        return carModelOptional;
    }

    @Override
    public CarModel saveCarModel(CarModel carModel) {
        return carModelRepository.save(carModel);
    }

    @Override
    public void updateCarModel(CarModel carModel, Long id) {
        Optional<CarModel> carModelOptional = carModelRepository.findById(id);
        if (carModelOptional.isPresent()) {
            CarModel carModelToUpdate = carModelOptional.get();
            if (Objects.nonNull(carModel.getName()) && !carModel.getName().isEmpty()) {
                carModelToUpdate.setName(carModel.getName());
            }
            if (carModel.getYearOfProduction() > 0) {
                carModelToUpdate.setYearOfProduction(carModel.getYearOfProduction());
            }
            carModelRepository.updateCarModel(carModelToUpdate.getName(), carModelToUpdate.getYearOfProduction(), id);
        } else {
            throw new CarModelNotFoundException();
        }
    }

    @Override
    public void deleteCarModel(Long id) {
        Optional<CarModel> carModelOptional = carModelRepository.findById(id);
        if (carModelOptional.isPresent()) {
            carModelOptional.get().getCarParts().forEach(carPart -> carPart.setCarModels(null) );
            carModelRepository.deleteById(id);
        } else {
            throw new CarModelNotFoundException();
        }
    }

    @Override
    public Collection<CarModel> getCarModelByName(String name) {
        Collection<CarModel> carModels = carModelRepository.findByName(name);
        if (carModels.isEmpty()) {
            throw new CarModelNotFoundException();
        }
        return carModels;
    }

    @Override
    public Collection<CarModel> getCarModelByYearOfProduction(int yearOfProduction) {
        Collection<CarModel> carModels = carModelRepository.findByYearOfProduction(yearOfProduction);
        if (carModels.isEmpty()) {
            throw new CarModelNotFoundException();
        }
        return carModels;
    }
}
