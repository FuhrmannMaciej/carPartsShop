package com.carPartsShopDisplay.repository;

import com.carPartsShopDisplay.entity.CarPartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarPartModelRepository extends JpaRepository<CarPartModel, Long> {

    Optional<CarPartModel> findByCarPartSourceSystemIdAndCarModelSourceSystemId(Long carPartSourceSystemId, Long carModelSourceSystemId);
}
