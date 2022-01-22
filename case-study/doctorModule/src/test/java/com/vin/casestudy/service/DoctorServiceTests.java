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

    @DisplayName("Service : Car Not Null")
    @Test
    public void testDoctorSave(){
        DoctorDto doctor = new DoctorDto();
        doctor.setName("vinay");
        doctor.setId(10L);
        doctor.setSpec("dermatology");
        doctor.setHsNm("Govt hospital");
        doctor.setHsLoc("hyderabad");
        doctor.setVisit(true);

        DoctorDto resDoc = service.createDoctor(doctor);
        Assertions.assertNotNull(resDoc);
    }
//
//    @DisplayName("Service : Doctor by id : invalid")
//    @Test
//    public void testDoctorByInvalidId(){
//        Assertions.assertThrows(
//                InvalidIdException.class,
//                ()-> service.deleteDoctor(5L)
//        );
//    }

    @DisplayName("service : Doctor by spec :")
    @Test
    public void testDoctorFindBySpec(){
        var op = service.findVisitingDoctorBySpec("Dermatology");
        Assertions.assertNotNull(op.get(1));
    }




    @DisplayName("Service : Doctors Count By Loc and Spec")
    @Test
    public void testDoctorsCountByLocAndSpec(){
        var op = service.countOfDoctorsByLocalityAndSpec("chenai", "orthopedics");
        Assertions.assertEquals(2L,op);
    }
}
