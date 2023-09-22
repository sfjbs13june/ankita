package com.ankita.hospital.controller;

import com.ankita.hospital.model.Prescription;
import com.ankita.hospital.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PrescriptionController {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @PostMapping("/saveprescription")
    public Prescription saveprescription(@RequestBody Prescription prescription)
    {
        Prescription pres=prescriptionRepository.save(prescription);
        return pres;
    }

    @GetMapping("/viewprescription")
    public Prescription getprescription(@RequestParam String patientName){
        Prescription prescription=prescriptionRepository.findBypatientName(patientName);
        return prescription;
    }



}
