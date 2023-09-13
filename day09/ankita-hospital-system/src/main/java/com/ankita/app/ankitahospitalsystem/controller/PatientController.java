package com.ankita.app.ankitahospitalsystem.controller;

import com.ankita.app.ankitahospitalsystem.model.Patient;
import com.ankita.app.ankitahospitalsystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/save")
    public Patient savePatientDetails(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }

    @GetMapping("/get")
    public List<Patient> getPatientdetails()
    {
        return (List<Patient>) patientRepository.findAll();
    }

    @PutMapping("/update")
    public String updatePatientDetails(@RequestParam("pid") int pid,@RequestBody Patient patient){
        patientRepository.save(patient);
        return "updated Succesfully";
    }


    @DeleteMapping("/delete")
    public String deletePatientDetails(@RequestParam("pid") int pid){
        patientRepository.deleteById(pid);
        return "deleted Succesfully";
    }


}
