package com.example.service.doctor;

import com.example.dao.doctor.DoctorRepository;
import com.example.mailservice.EmailService;
import com.example.model.doctor.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private EmailService service;

    @PostConstruct
    public void initDoctor() {
        doctorRepository.saveAll(Stream.of(new Doctor(101, "John", "Cardiac"), new Doctor(102, "peter", "Eye")).collect(Collectors.toList()));
    }

    public List<Doctor> getDoctors() {
        service.sendEmail();
        return doctorRepository.findAll();
    }
}
