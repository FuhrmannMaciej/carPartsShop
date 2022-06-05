package com.example.demo.repository;

import com.example.demo.entity.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPartRepository extends JpaRepository<CarPart, Long> {
    CarPart findByName(String name);
}
