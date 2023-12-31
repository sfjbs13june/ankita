package com.ankita.app.mongodbhospitalmanagement.respository;

import com.ankita.app.mongodbhospitalmanagement.model.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital, String> {

    public Hospital findByhospitalname(String hospitalname);

    public Hospital findByhospitalid(String hospitalid);

    public Hospital findByaddress(String address);

    public Hospital deleteByaddress(String address);

    public Hospital deleteByhospitalname(String hospitalname);

    public Hospital save(Hospital hospital);
}
