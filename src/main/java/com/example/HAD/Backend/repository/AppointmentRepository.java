package com.example.HAD.Backend.repository;

import com.example.HAD.Backend.bean.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}