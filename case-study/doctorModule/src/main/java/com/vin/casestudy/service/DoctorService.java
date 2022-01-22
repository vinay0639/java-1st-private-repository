package com.vin.casestudy.service;

import com.vin.casestudy.domain.Doctor;
import com.vin.casestudy.dto.DoctorDto;
import com.vin.casestudy.exception.InvalidIdException;

import java.util.List;

public interface DoctorService {

    public DoctorDto createDoctor(DoctorDto dto);

    public DoctorDto updateDocInfo(DoctorDto doctor);

    public void deleteDoctor(Long id) throws InvalidIdException;

    public List<DoctorDto> findVisitingDoctorBySpec(String spec);

    public List<DoctorDto> findDoctorBySpec(String spec);

    public List<DoctorDto> findDoctorByLoc(String loc);

    public List<DoctorDto> findPermanentDoctorBySpec(String spec);

    public Long countOfDoctorsByLocalityAndSpec(String loc , String spec);

    public List<DoctorDto> listOfAllDoctors();


}
