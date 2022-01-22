package com.vin.casestudy.repository;

import com.vin.casestudy.domain.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DoctorRepositoryTests {

    @Autowired
    private DoctorRepository repository;

    @DisplayName("Doctor repo : creating Doctor")
    @Test
    public void testCreateDoctor(){
        var doctor = new Doctor();
        doctor.setId(100L);
        doctor.setName("vinay");
        doctor.setSpec("neurologist");
        doctor.setHsLoc("bellary");
        doctor.setHsNm("govt hospital");
        doctor.setVisit(true);

        repository.save(doctor);
    }

//    @DisplayName("Doctor repo : Deleting Doctor")
//    @Test
//    public void testDeleteDoctor(){
//        Doctor doc = new Doctor();
//
//        repository.deleteById(1L);
//    }
//    @Test
//    public void testDoctorUpdate(){
//        Doctor doc = repository.findById(1L).get();
//        doc.setName("vinay");
//        repository.save(doc);
//
//        Assertions.assertEquals("vinay" , repository.findById(1L).get().getName());
//    }
}
