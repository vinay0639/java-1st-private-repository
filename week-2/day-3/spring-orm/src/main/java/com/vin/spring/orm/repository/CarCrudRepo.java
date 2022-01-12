package com.vin.spring.orm.repository;

import com.vin.spring.orm.domain.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarCrudRepo extends CrudRepository<Car, Long> {

}
