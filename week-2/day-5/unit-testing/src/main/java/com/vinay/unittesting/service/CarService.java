package com.vinay.unittesting.service;

import com.vinay.unittesting.domain.Car;

import java.util.Optional;

public interface CarService {
    Car saveCar(Car car);

    Optional<Car> findCarById(Long id);
}
