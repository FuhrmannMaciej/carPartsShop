package com.carPartsShop.repository;

import com.carPartsShop.entity.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {
    @Query(value = "SELECT c FROM car_model c WHERE c.name = :name", nativeQuery = true)
    Collection<CarModel> findByName(@Param("name") String name);

    @Query(value = "SELECT c FROM car_model c WHERE c.year_of_production = :year_of_production", nativeQuery = true)
    Collection<CarModel> findByYearOfProduction(@Param("year_of_production") int yearOfProduction);

    @Transactional
    @Modifying
    @Query(value = "UPDATE car_model c SET c.name = :name, c.year_of_production = :year_of_production WHERE c.id = :id", nativeQuery = true)
    void updateCarModel(@Param("name") String name, @Param("year_of_production") int yearOfProduction , @Param("id") Long id);
}
