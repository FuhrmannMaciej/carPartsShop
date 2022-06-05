package com.example.demo.repository;

import com.example.demo.entity.CarModel;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {
    CarModel findByName(String name);

    CarModel findByYearOfProduction(int yearOfProduction);
}
