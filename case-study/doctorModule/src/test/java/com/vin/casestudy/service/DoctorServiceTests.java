package com.vin.casestudy.service;

import com.vin.casestudy.domain.Doctor;
import com.vin.casestudy.dto.DoctorDto;
import com.vin.casestudy.exception.InvalidIdException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class DoctorServiceTests {
    @Autowired
    private DoctorServiceImpl service;



    @DisplayName("service : Doctor by spec :")
    @Test
    public void testDoctorFindBySpec(){
        var op = service.findVisitingDoctorBySpec("Dermatology");
        Assertions.assertNotNull(op.get(1));
    }

    @DisplayName("sevice test: Doctor by locality")
    @Test
    public void testDoctorFindByloc(){
        var op = service.findDoctorByLoc("banglore");
        Assertions.assertNotNull(op.get(1));
    }


    @DisplayName("Service : Doctors Count By Loc and Spec")
    @Test
    public void testDoctorsCountByLocAndSpec(){
        var op = service.countOfDoctorsByLocalityAndSpec("chenai", "orthopedics");
        Assertions.assertEquals(2L,op);
    }

    @DisplayName("service : Find All Doctor test")
    @Test
    public void testDoctorFindAll(){
         var op = service.listOfAllDoctors();
         Assertions.assertNotNull(op.get(1));
    }
}
