package com.vin.casestudy.controller;


import com.vin.casestudy.dto.AppResponse;
import com.vin.casestudy.dto.DoctorDto;
import com.vin.casestudy.exception.InvalidIdException;
import com.vin.casestudy.exception.NoDoctorsFoundException;
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
        try {
            var svObj = service.updateDocInfo(dto);

            var response = new AppResponse<DoctorDto>();
            response.setStatus("success");
            response.setMessage("Doctor updated successfully");
            response.setBody(svObj);

            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (InvalidIdException e){
            var response = new AppResponse<DoctorDto>();
            response.setStatus("fail");
            response.setMessage(e.getMessage());


            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AppResponse<DoctorDto>> deleteDoctor(@PathVariable("id") Long id){
        try {
            service.deleteDoctor(id);

            var response = new AppResponse<DoctorDto>();
            response.setStatus("success");
            response.setMessage("Doctor deleted successfully");

            return ResponseEntity.ok(response);
        }catch (InvalidIdException e){
            var response = new AppResponse<DoctorDto>();
            response.setStatus("failed");
            response.setMessage(e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
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
        try {
            var svObj = service.findVisitingDoctorBySpec(spec);
            var response = new AppResponse<List<DoctorDto>>();
            response.setStatus("success");
            response.setMessage("Doctors fetched successfully");
            response.setBody(svObj);

            return ResponseEntity.ok(response);
        }catch (NoDoctorsFoundException e){
            var response = new AppResponse<List<DoctorDto>>();
            response.setStatus("failed");
            response.setMessage(e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/per/{spec}")
    public ResponseEntity<AppResponse<List<DoctorDto>>> findPermanentDoctorBySpec( @PathVariable String spec){
        try {
            var svObj = service.findPermanentDoctorBySpec(spec);
            var response = new AppResponse<List<DoctorDto>>();
            response.setStatus("success");
            response.setMessage("Doctors fetched successfully");
            response.setBody(svObj);

            return ResponseEntity.ok(response);
        }catch (NoDoctorsFoundException e){
            var response = new AppResponse<List<DoctorDto>>();
            response.setStatus("failed");
            response.setMessage(e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/spec/{spec}")
    public ResponseEntity<AppResponse<List<DoctorDto>>> findDoctorBySpec( @PathVariable String spec){
        try {
            var svObj = service.findDoctorBySpec(spec);
            var response = new AppResponse<List<DoctorDto>>();
            response.setStatus("success");
            response.setMessage("Doctors fetched successfully for given Specialization");
            response.setBody(svObj);

            return ResponseEntity.ok(response);
        }catch (NoDoctorsFoundException e){
            var response = new AppResponse<List<DoctorDto>>();
            response.setStatus("failed");
            response.setMessage(e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/loc/{loc}")
    public ResponseEntity<AppResponse<List<DoctorDto>>> findDoctorByLoc( @PathVariable String loc){
        try {
            var svObj = service.findDoctorByLoc(loc);
            var response = new AppResponse<List<DoctorDto>>();
            response.setStatus("success");
            response.setMessage("Doctors fetched successfully for given Locality");
            response.setBody(svObj);

            return ResponseEntity.ok(response);
        }catch (NoDoctorsFoundException e){
            var response = new AppResponse<List<DoctorDto>>();
            response.setStatus("failed");
            response.setMessage(e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/list")
    public ResponseEntity<AppResponse<List<DoctorDto>>> listOfAllDoctors(){
        try {
            var svObj = service.listOfAllDoctors();
            var response = new AppResponse<List<DoctorDto>>();
            response.setStatus("success");
            response.setMessage("Doctors fetched successfully");
            response.setBody(svObj);

            return ResponseEntity.ok(response);
        }catch (NoDoctorsFoundException e){
            var response = new AppResponse<List<DoctorDto>>();
            response.setStatus("failed");
            response.setMessage(e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
