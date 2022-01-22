package com.vin.casestudy.controller;


import com.vin.casestudy.dto.AppResponse;
import com.vin.casestudy.dto.DoctorDto;
import com.vin.casestudy.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/doctor")
@RestController
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping
    public ResponseEntity<AppResponse<DoctorDto>> createDoctor(@RequestBody DoctorDto dto){

        var svObj = service.createDoctor(dto);

        var response = new AppResponse<DoctorDto>();
        response.setStatus("success");
        response.setMessage("Doctor registered successfully");
        response.setBody(svObj);

        return new ResponseEntity(dto , HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AppResponse<DoctorDto>> updateDocInfo(@RequestBody DoctorDto dto){

        var svObj = service.updateDocInfo(dto);

        var response = new AppResponse<DoctorDto>();
        response.setStatus("success");
        response.setMessage("Doctor updated successfully");
        response.setBody(svObj);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AppResponse<DoctorDto>> deleteDoctor(@PathVariable("id") Long id){

         service.deleteDoctor(id);

        var response = new AppResponse<DoctorDto>();
        response.setStatus("success");
        response.setMessage("Doctor deleted successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/count/{locality}/{spec}")
    public ResponseEntity<AppResponse<Long>> countOfDoctorsByLocalityAndSpec(@PathVariable String locality ,@PathVariable String spec){

       var count =  service.countOfDoctorsByLocalityAndSpec(locality, spec);
        var response = new AppResponse<Long>();
        response.setStatus("success");
        response.setMessage("Available Doctors");
        response.setBody(count);

        return ResponseEntity.ok(response);
    }
    @GetMapping("/{spec}")
    public ResponseEntity<AppResponse<List<DoctorDto>>> findVisitingDoctorBySpec( @PathVariable String spec){

        var svObj = service.findVisitingDoctorBySpec(spec );
        var response = new AppResponse<List<DoctorDto>>();
        response.setStatus("success");
        response.setMessage("Doctors fetched successfully");
        response.setBody(svObj);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/per/{spec}")
    public ResponseEntity<AppResponse<List<DoctorDto>>> findPermanentDoctorBySpec( @PathVariable String spec){

        var svObj = service.findPermanentDoctorBySpec(spec);
        var response = new AppResponse<List<DoctorDto>>();
        response.setStatus("success");
        response.setMessage("Doctors fetched successfully");
        response.setBody(svObj);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/spec/{spec}")
    public ResponseEntity<AppResponse<List<DoctorDto>>> findDoctorBySpec( @PathVariable String spec){

        var svObj = service.findDoctorBySpec(spec );
        var response = new AppResponse<List<DoctorDto>>();
        response.setStatus("success");
        response.setMessage("Doctors fetched successfully for given Specialization");
        response.setBody(svObj);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/loc/{loc}")
    public ResponseEntity<AppResponse<List<DoctorDto>>> findDoctorByLoc( @PathVariable String loc){

        var svObj = service.findDoctorByLoc(loc);
        var response = new AppResponse<List<DoctorDto>>();
        response.setStatus("success");
        response.setMessage("Doctors fetched successfully for given Locality");
        response.setBody(svObj);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/list")
    public ResponseEntity<AppResponse<List<DoctorDto>>> listOfAllDoctors(){
        var svObj = service.listOfAllDoctors();
        var response = new AppResponse<List<DoctorDto>>();
        response.setStatus("success");
        response.setMessage("Doctors fetched successfully");
        response.setBody(svObj);

        return ResponseEntity.ok(response);
    }
}
