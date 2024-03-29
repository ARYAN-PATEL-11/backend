package com.example.HAD.Backend.service;

import com.example.HAD.Backend.entities.Patient;
import com.example.HAD.Backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient getPatientById(Integer patientId) {
        return  patientRepository.findPatientByPatientId(patientId);
    }

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public Patient findPatientById(Integer patientId) {
        return patientRepository.findPatientByPatientId(patientId);
    }
}