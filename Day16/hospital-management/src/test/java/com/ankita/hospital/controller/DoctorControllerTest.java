package com.ankita.hospital.controller;

import com.ankita.hospital.model.Appointment;
import com.ankita.hospital.model.Prescription;
import com.ankita.hospital.repository.AppointmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DoctorControllerTest {
    @InjectMocks
    private DoctorController doctorController;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private Appointment appointment;

    @Mock
    private Prescription prescription;

    @Test
    public void saveAppointmentTest() {
        Prescription prescription = new Prescription();
        prescription.setPrescriptionId("pres1001");
        prescription.setAppointmentId("app001");
        prescription.setDescription("fever");
        prescription.setDoctorName("San");
        prescription.setPatientName("swathi");
        Appointment appointment=new Appointment();
        appointment.setAppointmentId("app001");
        appointment.setPatientName("swathi");
        appointment.setDoctorName("San");
        appointment.setDate("01/09/2023");
        appointment.setPrescription(prescription);
        when(appointmentRepository.save(appointment)).thenReturn(appointment);
        Appointment result = doctorController.saveAppointment(appointment);
        assertEquals("app001",result.getAppointmentId());
        assertEquals("swathi",result.getPatientName());
        assertEquals("San",result.getDoctorName());
        assertEquals("01/09/2023",result.getDate());
        assertEquals(prescription,result.getPrescription());

    }

    @Test
    public void getAppointmentTest() {

        Prescription prescription = new Prescription("pres1001", "app001", "fever", "swathi", "San");
        Appointment appointment=new Appointment("app001","swathi","San","01/09/2023",prescription);
        when(appointmentRepository.findBydoctorName(anyString())).thenReturn(appointment);
        Appointment result = (Appointment) (Appointment) doctorController.getAppointment("San");
        assertEquals("app001",result.getAppointmentId());
        assertEquals("swathi",result.getPatientName());
        assertEquals("San",result.getDoctorName());
        assertEquals("01/09/2023",result.getDate());
        assertEquals(prescription,result.getPrescription());
    }
}
