package com.ankita.app.ankitahospitalsystem.repository;

import com.ankita.app.ankitahospitalsystem.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer>{
    public Patient findByPatientName(String patientname);

    public Patient findByPatientId(String patientid);

    public Patient findByHospitalName(String hospitalname);

    public Patient findByDisease(String disease);

    public Patient deleteByPatientName(String patientname);

    public Patient save(Patient patient);

}
