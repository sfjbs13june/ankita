package com.ankita.app.ankitahospitalsystem.repository;

import com.ankita.app.ankitahospitalsystem.model.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, Integer> {
}
