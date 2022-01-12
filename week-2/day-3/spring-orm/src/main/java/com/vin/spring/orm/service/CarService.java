package com.vin.spring.orm.service;

import com.vin.spring.orm.domain.Car;
import com.vin.spring.orm.repository.CarCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarCrudRepo repository;

    public Car saveCar(Car car){
        return repository.save(car);
    }
}
