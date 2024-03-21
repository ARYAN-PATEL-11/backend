package com.example.HAD.Backend.entities;
import com.example.HAD.Backend.dto.DoctorDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctorId")
    private Integer doctorId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 10, unique = true)
    private String mobileNo;

    @Column(nullable = false)
    private Calendar dob;

    @Column(nullable = false)
    private String gender;

    @OneToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Login login;

    @Column(name = "speciality")
    private String speciality;

    @Column
    private Integer experience;

    @JsonIgnore
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<MedicalRecords> medicalRecords = new ArrayList<>();

    public Doctor(DoctorDTO doctorDTO) {
        this.name = doctorDTO.getName();
        this.dob = doctorDTO.getDob();
        this.gender = doctorDTO.getGender();
        this.mobileNo = doctorDTO.getMobileNo();
        this.speciality = doctorDTO.getSpeciality();
        this.experience = doctorDTO.getExperience();
    }
}