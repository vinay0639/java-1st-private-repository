package com.vinay.unittesting.service;

import com.vinay.unittesting.domain.Car;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService{
    @Override
    public Car saveCar(Car car) {

        return car;
    }
}