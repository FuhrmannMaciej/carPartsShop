package com.carPartsShop.repository;

import com.carPartsShop.entity.CarPart;
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

    @Transactional
    @Modifying
    @Query(value = "UPDATE car_part c SET c.name = :name, c.price = :price, c.quantity = :quantity WHERE c.id = :id", nativeQuery = true)
    void updateCarPart(@Param("name") String name, @Param("price") double price , @Param("quantity") int quantity, @Param("id") Long id);
}
