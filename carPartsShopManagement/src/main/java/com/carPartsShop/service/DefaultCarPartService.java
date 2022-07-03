package com.carPartsShop.service;

import com.carPartsShop.entity.CarModel;
import com.carPartsShop.exception.CarModelNotFoundException;
import com.carPartsShop.exception.CarPartNotFoundException;
import com.carPartsShop.repository.CarModelRepository;
import com.carPartsShop.repository.CarPartRepository;
import com.carPartsShop.entity.CarPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Service
public class DefaultCarPartService implements CarPartService {

    @Autowired
    private CarPartRepository carPartRepository;

    @Autowired
    private CarModelRepository carModelRepository;

    @Autowired
    private CarPartModelProducerService carPartModelProducerService;

    @Override
    public Collection<CarPart> getAllCarParts() {
        return carPartRepository.findAll();
    }

    @Override
    public Page<CarPart> getAllCarParts(Pageable pageable) {
        return carPartRepository.findAll(pageable);
    }

    @Override
    public Optional<CarPart> getCarPartById(Long id) {
        Optional<CarPart> carPart = carPartRepository.findById(id);
        if (carPart.isEmpty()) {
            throw new CarPartNotFoundException();
        }
        return carPart;
    }

    @Override
    public CarPart saveCarPart(CarPart carPart, Long carModelId) {
        Optional<CarModel> carModel = carModelRepository.findById(carModelId);
        if (carModel.isPresent()) {
            CarPart savedCarPart = carPartRepository.save(carPart);
            carPartRepository.addCarPartToCarModel(savedCarPart.getId(), carModelId);
            carPartModelProducerService.sendCarPartModelUpdate(carModelId, savedCarPart.getId());
            return savedCarPart;
        }
        throw new CarModelNotFoundException();
    }

    @Override
    public void updateCarPart(CarPart carPart, Long id) {
        Optional<CarPart> optionalCarPart = carPartRepository.findById(id);
        if (optionalCarPart.isPresent()) {
            CarPart carPartToUpdate = optionalCarPart.get();
            if (Objects.nonNull(carPart.getName()) && !carPart.getName().isEmpty()) {
                carPartToUpdate.setName(carPart.getName());
            }
            if (carPart.getPrice() >= 0) {
                carPartToUpdate.setPrice(carPart.getPrice());
            }
            if (carPart.getQuantity() >= 0) {
                carPartToUpdate.setQuantity(carPart.getQuantity());
            }
            carPartRepository.updateCarPart(carPartToUpdate.getName(), carPartToUpdate.getPrice(), carPartToUpdate.getQuantity(), id);
        } else {
            throw new CarPartNotFoundException();
        }
    }

    @Override
    public void deleteCarPart(Long id) {
        Optional<CarPart> carPartOptional = carPartRepository.findById(id);
        if (carPartOptional.isPresent()) {
            carPartOptional.get().getCarModels().forEach(carPart -> carPart.setCarParts(null) );
            carPartRepository.deleteById(id);
        } else {
            throw new CarPartNotFoundException();
        }
    }

    @Override
    public Collection<CarPart> getCarPartByName(String name) {
        Collection<CarPart> carParts = carPartRepository.findByName(name);
        if (carParts.isEmpty()) {
            throw new CarPartNotFoundException();
        }
        return carParts;
    }

    @Override
    public void addCarPartToCarModel(Long carPartId, Long carModelId) {
        carPartRepository.addCarPartToCarModel(carPartId, carModelId);
        carPartModelProducerService.sendCarPartModelUpdate(carPartId, carModelId);
    }
}
