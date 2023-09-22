package com.ankita.hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Appointment {
    @Id
    @GeneratedValue
    @Column(name = "appointmentId")
    String appointmentId;
    @Column(name = "patientName")
    String patientName;
    @Column(name = "doctorName")
    String doctorName;
    @Column(name = "date")
    String date;
    @Column(name = "prescription")
    Prescription prescription;

}