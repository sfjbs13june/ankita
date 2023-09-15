package com.ankita.rabitMq.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Hospital.class)
public class Patient
{
private String patientName;
private String patientId;

    public String getPatientName() {
        return patientName;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Patient{" +
                "patientName='" + patientName + '\'' +
                ", patientId='" + patientId + '\'' +
                '}';
    }
}

