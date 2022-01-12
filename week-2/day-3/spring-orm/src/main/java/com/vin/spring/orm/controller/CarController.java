package com.vin.spring.orm.controller;

import com.vin.spring.orm.domain.Car;
import com.vin.spring.orm.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/car")
@RestController
public class CarController {
    @Autowired
    private CarService service;

    @PostMapping
    private String saveCar(@RequestBody Car car){
        service.saveCar(car);
        return "car saved successfully";
    }

}
