package com.ankita.app.mongodbhospitalmanagement.controller;

import com.ankita.app.mongodbhospitalmanagement.model.Hospital;
import com.ankita.app.mongodbhospitalmanagement.model.Patient;
import com.ankita.app.mongodbhospitalmanagement.respository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hospital")
public class HospitalController {

    @Autowired
    HospitalRepository hospitalRepository;


    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public Hospital savehospital(@RequestBody Hospital hospital){
        return hospitalRepository.save(hospital);
    }

    @RequestMapping(value = "/read" , method = RequestMethod.GET)
    public List<Hospital> gethospital(@RequestParam("hospitalname") String hospitalname) {
        return hospitalRepository.findAll();
    }

    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public Hospital updatehospital(@RequestParam("hospitalname") String hospitalname, @RequestParam("address") String address){
        Hospital hospital= hospitalRepository.findByhospitalname(hospitalname);
        hospital.setAddress(address);
        return hospitalRepository.save(hospital);
    }

    @RequestMapping(value = "/delete" , method = RequestMethod.DELETE)
    public String removehospital(@RequestParam("hospitalname") String hospitalname) {
        hospitalRepository.deleteByhospitalname(hospitalname);
        return "Deleted Successfully!!!";
    }



}
