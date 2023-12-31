package com.ankita.hospital.controller;
import com.ankita.hospital.model.Appointment;
import com.ankita.hospital.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping(value ="/save")
    public Appointment saveAppointment(@RequestBody Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    @GetMapping(value = "/doctorappointment")
    public Appointment getAppointment(@RequestParam String docterName){
        Appointment appointment=appointmentRepository.findBydoctorName(docterName);
        return appointment;
    }
}
