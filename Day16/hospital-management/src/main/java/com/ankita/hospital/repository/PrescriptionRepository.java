package com.ankita.hospital.repository;

import com.ankita.hospital.model.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends MongoRepository<Prescription,String> {
    public Prescription save(Prescription prescription);

    public Prescription findBypatientName(String patientName);
}
