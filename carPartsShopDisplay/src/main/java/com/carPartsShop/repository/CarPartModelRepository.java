package com.carPartsShop.repository;

import com.carPartsShop.entity.CarPartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPartModelRepository extends JpaRepository<CarPartModel, Long> {

}
