package com.carPartsShopManagement.service;

import com.carPartsShopManagement.config.AppConstants;
import com.carPartsShopManagement.entity.CarModel;
import com.carPartsShopManagement.entity.CarPart;
import com.carPartsShopManagement.exception.CarPartOrCarModelNotFoundException;
import com.carPartsShopManagement.kafka.dto.CarPartModelKafkaDto;
import com.carPartsShopManagement.repository.CarModelRepository;
import com.carPartsShopManagement.repository.CarPartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class CarPartModelProducerService {

    @Autowired
    private KafkaTemplate<String, CarPartModelKafkaDto> kafkaTemplate;

    @Autowired
    private CarPartRepository carPartRepository;

    @Autowired
    private CarModelRepository carModelRepository;

    public void syncCarPartModels() {
        int counter = 0;
        List<CarModel> carModels = carModelRepository.findAll();

        for (CarModel carModel : carModels) {
            List<CarPart> carParts = carModel.getCarParts().stream().toList();
            for (CarPart carPart : carParts) {
                CarPartModelKafkaDto json = createCarPartModelKafkaDto(carModel, carPart);
                counter++;
                kafkaTemplate.send(AppConstants.TOPIC, json);
            }
        }
        log.info("Sent {} car part models to Kafka", counter);
    }

    private CarPartModelKafkaDto createCarPartModelKafkaDto(CarModel carModel, CarPart carPart) {
        CarPartModelKafkaDto json = new CarPartModelKafkaDto();
        json.setCarModelSourceSystemId(carModel.getId());
        json.setCarPartSourceSystemId(carPart.getId());
        json.setCarModelName(carModel.getName());
        json.setYearOfProduction(carModel.getYearOfProduction());
        json.setCarPartName(carPart.getName());
        json.setPrice(carPart.getPrice());
        json.setQuantity(carPart.getQuantity());
        return json;
    }

    public void sendCarPartModelUpdate(Long carModelId, Long carPartId) {
        Optional<CarModel> carModel = carModelRepository.findById(carModelId);
        Optional<CarPart> carPart = carPartRepository.findById(carPartId);
        if (carModel.isPresent() && carPart.isPresent()) {
            CarPartModelKafkaDto json = createCarPartModelKafkaDto(carModel.get(), carPart.get());
            kafkaTemplate.send(AppConstants.TOPIC, json);
        } else {
            throw new CarPartOrCarModelNotFoundException();
        }
    }
}
