package com.example.demo.repository;

import com.example.demo.entity.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {
    Optional<CarModel> findByName(String name);

    Optional<CarModel> findByYearOfProduction(int yearOfProduction);

    @Transactional
    @Modifying
    @Query(value = "UPDATE car_model c SET c.name = :name, c.year_of_production = :year_of_production WHERE c.id = :id", nativeQuery = true)
    void updateCarModel(@Param("name") String name, @Param("year_of_production") int yearOfProduction , @Param("id") Long id);
}
