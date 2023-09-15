package com.ankita.rabitMq.controller;

import com.ankita.rabitMq.model.Hospital;
import com.ankita.rabitMq.model.Patient;
import com.ankita.rabitMq.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rabbitmq/")
public class WebController {
  @Autowired
  RabbitMQSender rabbitMQSender;

  @GetMapping(value = "/producer")
  public String producer1(@RequestParam("hospitalName") String hospitalName, @RequestParam("hospitalAddress") String hospitalAddress ) {

    Hospital hp = new Hospital();
    hp.setHospitalName(hospitalName);
    hp.setHospitalAddress(hospitalAddress);
    rabbitMQSender.send(hp);
    return "Message sent to the hospital RabbitMQ  Successfully";
  }
  @GetMapping(value = "/producer")
  public String producer2(@RequestParam("patientId") String patientId, @RequestParam("patientName") String patientName) {

    Patient pt=new Patient();
    pt.setPatientId(patientId);
    pt.setPatientName(patientName);
    rabbitMQSender.send(pt);
    return "Message sent to the patient RabbitMQ  Successfully";
  }

  @PostMapping(value = "/hospital")
  public String postEmployee(@RequestBody Hospital hospital) {

    rabbitMQSender.send(hospital);

    return "Message sent to the  hospital RabbitMQ  Successfully";
  }

  @PostMapping(value = "/patient")
  public String postEmployee(@RequestBody Patient patient) {

    rabbitMQSender.send(patient);

    return "Message sent to the patient RabbitMQ  Successfully";
  }
}
