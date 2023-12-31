package com.ankita.hospital.repository;

import com.ankita.hospital.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment,String> {
    public Appointment findBydoctorName(String doctorName);

    public Appointment findBypatientName(String patientName);

    public Appointment save(Appointment appointment);
}
