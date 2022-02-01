package com.vin.casestudy.service;

import com.vin.casestudy.domain.Doctor;
import com.vin.casestudy.dto.DoctorDto;
import com.vin.casestudy.exception.InvalidIdException;
import com.vin.casestudy.exception.NoDoctorsFoundException;

import java.util.List;

public interface DoctorService {

    public DoctorDto createDoctor(DoctorDto dto);

    public DoctorDto updateDocInfo(DoctorDto doctor) throws InvalidIdException;

    public void deleteDoctor(Long id) throws InvalidIdException;

    public List<DoctorDto> findVisitingDoctorBySpec(String spec) throws NoDoctorsFoundException;

    public List<DoctorDto> findDoctorBySpec(String spec)throws NoDoctorsFoundException;

    public List<DoctorDto> findDoctorByLoc(String loc) throws NoDoctorsFoundException;

    public List<DoctorDto> findPermanentDoctorBySpec(String spec) throws NoDoctorsFoundException;

    public Long countOfDoctorsByLocalityAndSpec(String loc , String spec);

    public List<DoctorDto> listOfAllDoctors() throws NoDoctorsFoundException;


}
