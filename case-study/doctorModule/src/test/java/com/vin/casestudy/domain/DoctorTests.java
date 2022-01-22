package com.vin.casestudy.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DoctorTests {

    @DisplayName("Domain : checking object creation")
    @Test
    void testObjectCreation(){
        var doctor = new Doctor();
        Assertions.assertNotNull(doctor);
    }

    @DisplayName("Domain : checking getters and setters")
    @Test
    void testObjectGettersSetters(){
        var doc = new Doctor();

        doc.setId(10L);
        doc.setName("vinay");
        doc.setSpec("cardiologist");
        doc.setHsNm("aarogya hospital");
        doc.setHsLoc("bellary");
        doc.setVisit(true);

        Assertions.assertEquals(10, doc.getId());
        Assertions.assertEquals("vinay", doc.getName());
        Assertions.assertEquals("cardiologist", doc.getSpec());
        Assertions.assertEquals("aarogya hospital", doc.getHsNm());
        Assertions.assertEquals("bellary", doc.getHsLoc());
        Assertions.assertEquals(true, doc.getVisit());
    }
}
