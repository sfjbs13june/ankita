package com.ankita.hospital.controller;

import com.ankita.hospital.model.Appointment;
import com.ankita.hospital.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping(value="/save")
    public Appointment saveAppointment(@RequestBody Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    @GetMapping(value="/myappointment")
    public Appointment getAppointments(@RequestParam String patientName){
        Appointment appointment=appointmentRepository.findBypatientName(patientName);
        return  appointment;
    }

}
