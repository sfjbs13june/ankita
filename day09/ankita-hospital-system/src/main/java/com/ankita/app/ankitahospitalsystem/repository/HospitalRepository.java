package com.ankita.app.ankitahospitalsystem.repository;

import com.ankita.app.ankitahospitalsystem.model.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, Integer> {

    public Hospital findByhospitalname(String hospitalname);

    public Hospital findByhospitalid(String hospitalid);

    public Hospital findByaddress(String address);

    public Hospital deleteByaddress(String address);

    public Hospital deleteByhospitalname(String hospitalname);

    public Hospital save(Hospital hospital);

}
