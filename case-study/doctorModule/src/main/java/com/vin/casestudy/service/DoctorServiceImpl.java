package com.vin.casestudy.service;

import com.vin.casestudy.domain.Doctor;
import com.vin.casestudy.dto.DoctorDto;
import com.vin.casestudy.exception.InvalidIdException;
import com.vin.casestudy.exception.NoDoctorsFoundException;
import com.vin.casestudy.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional(
        isolation = Isolation.READ_UNCOMMITTED,
        rollbackFor = {SQLException.class, InvalidIdException.class},
        noRollbackFor = InvalidIdException.class
)

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    public DoctorRepository repository;


    @Override
    public DoctorDto createDoctor(DoctorDto doctor) {

        var doc = new Doctor();
        doc.setId(doctor.getId());
        doc.setName(doctor.getName());
        doc.setSpec(doctor.getSpec());
        doc.setHsNm(doctor.getHsNm());
        doc.setHsLoc(doctor.getHsLoc());
        doc.setVisit(doctor.getVisit());

        repository.save(doc);
        return doctor;
    }

    @Override
    public DoctorDto updateDocInfo(DoctorDto doctor) throws InvalidIdException{
    Doctor doc = repository.findById(doctor.getId()).orElseThrow(
            () -> new InvalidIdException("enter a valid id :")
    );
    var doc1 = new Doctor();
        doc1.setId(doctor.getId());
        doc1.setName(doctor.getName());
        doc1.setSpec(doctor.getSpec());
        doc1.setHsNm(doctor.getHsNm());
        doc1.setHsLoc(doctor.getHsLoc());
        doc1.setVisit(doctor.getVisit());
        repository.save(doc1);
        return doctor;
    }

    @Override
    public void deleteDoctor(Long id) throws InvalidIdException {
    if(repository.getById(id).getId().equals(id)){
        repository.deleteById(id);
    }
    else throw new InvalidIdException("Enter correct id" + id);
    }


    @Override
    public List<DoctorDto> findVisitingDoctorBySpec(String spec) throws NoDoctorsFoundException {

        List<Doctor> dto = repository.findAll();
        List<DoctorDto> dto1 = dto.stream()
                .filter(n-> n.getVisit()==true   && n.getSpec().equals(spec))
                .map (doc -> new DoctorDto(
                        doc.getId()
                        ,doc.getName()
                        ,doc.getSpec()
                        ,doc.getHsNm()
                        ,doc.getHsLoc()
                        ,doc.getVisit()
                ))
                        .collect(Collectors.toList());

        if(dto1.isEmpty()){
            throw new NoDoctorsFoundException("No Visiting Doctors found for given specialization ");
        }
        return dto1;
    }

    @Override
    public List<DoctorDto> findDoctorBySpec(String spec) throws NoDoctorsFoundException {
        List<Doctor> dto = repository.findAll();
        List<DoctorDto> dto1 = dto.stream()
                .filter(n-> n.getSpec().equals(spec))
                .map (doc -> new DoctorDto(
                        doc.getId(),
                        doc.getName(),
                        doc.getSpec(),
                        doc.getHsNm(),
                        doc.getHsLoc(),
                        doc.getVisit()
                ))
                .collect(Collectors.toList());

        if(dto1.isEmpty()){
            throw new NoDoctorsFoundException("No Doctors found for given specialization ");
        }
        return dto1;
    }

    @Override
    public List<DoctorDto> findDoctorByLoc(String loc) throws NoDoctorsFoundException{

            List<Doctor> dto = repository.findAll();
            List<DoctorDto> dto1 = dto.stream()
                    .filter(n-> n.getHsLoc().equals(loc))
                    .map (doc -> new DoctorDto(
                            doc.getId(),
                            doc.getName(),
                            doc.getSpec(),
                            doc.getHsNm(),
                            doc.getHsLoc(),
                            doc.getVisit()
                    ))
                    .collect(Collectors.toList());

            if(dto1.isEmpty()){
                throw new NoDoctorsFoundException("No Doctors found for given Locality ");
            }
            return dto1;
        }

    @Override
    public List<DoctorDto> findPermanentDoctorBySpec(String spec) throws NoDoctorsFoundException{
        List<Doctor> dto = repository.findAll();
        List<DoctorDto> dto1 = dto.stream()
                .filter(n-> n.getVisit()==false   && n.getSpec().equals(spec))
                .map (doc -> new DoctorDto(
                        doc.getId()
                        ,doc.getName()
                        ,doc.getSpec()
                        ,doc.getHsNm()
                        ,doc.getHsLoc()
                        ,doc.getVisit()
                ))
                .collect(Collectors.toList());

        if(dto1.isEmpty()){
            throw new NoDoctorsFoundException("No Permanent Doctors found for given specialization ");
        }
        return dto1;
    }


    @Override
    public Long countOfDoctorsByLocalityAndSpec(String loc , String spec) {
         Long count=0L;
        List<Doctor> doc = repository.findAll();

        for(int i=0 ; i<doc.size();i++){
            Doctor doctor = doc.get(i);
            if( doctor.getHsLoc().equals(loc) && doctor.getSpec().equals(spec)) count++;
        }
        return count ;
    }

    @Override
    public List<DoctorDto> listOfAllDoctors() throws NoDoctorsFoundException {
        List<Doctor> dto = repository.findAll();
        List<DoctorDto> dto1 = dto.stream()
                .map (doc -> new DoctorDto(
                        doc.getId()
                        ,doc.getName()
                        ,doc.getSpec()
                        ,doc.getHsNm()
                        ,doc.getHsLoc()
                        ,doc.getVisit()
                ))
                .collect(Collectors.toList());

        if(dto1.isEmpty()){
            throw new NoDoctorsFoundException("Doctors not yet available ");
        }
        return dto1;
    }

}
