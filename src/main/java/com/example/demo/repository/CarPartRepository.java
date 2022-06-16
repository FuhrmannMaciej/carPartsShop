package com.example.demo.repository;

import com.example.demo.entity.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public interface CarPartRepository extends JpaRepository<CarPart, Long> {
    @Query("SELECT c FROM CarPart c WHERE c.name = :name")
    Collection<CarPart> findByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO car_part_car_model (car_part_id, car_model_id) values (:car_part_id, :car_model_id)", nativeQuery = true)
    void addCarPartToCarModel(@Param("car_part_id") Long carPartId, @Param("car_model_id") Long carModelId);
}
