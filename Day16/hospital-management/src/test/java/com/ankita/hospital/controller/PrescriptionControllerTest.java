package com.ankita.hospital.controller;

import com.ankita.hospital.model.Prescription;
import com.ankita.hospital.repository.PrescriptionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PrescriptionControllerTest {

    @InjectMocks
    private PrescriptionController prescriptionController;
@Mock
    private PrescriptionRepository prescriptionRepository;

    @Mock
    private Prescription prescription;


    @Test
    public void saveprescription() {
        Prescription prescription = new Prescription();
        prescription.setPrescriptionId("pres1001");
        prescription.setAppointmentId("app001");
        prescription.setDescription("fever");
        prescription.setDoctorName("San");
        prescription.setPatientName("swathi");
        when(prescriptionRepository.save(prescription)).thenReturn(prescription);
        Prescription result =prescriptionController.saveprescription(prescription);
        assertEquals("pres1001", result.getPrescriptionId());
        assertEquals("app001", result.getAppointmentId());
        assertEquals("fever", result.getDescription());
        assertEquals("swathi", result.getPatientName());
        assertEquals("San", result.getDoctorName());
    }
    @Test
    public void getPrescriptionTest() {
        Prescription prescription = new Prescription("pres1001", "app001", "fever", "swathi", "San");
        when(prescriptionRepository.findBypatientName(anyString())).thenReturn(prescription);
        Prescription result = prescriptionController.getprescription("swathi");
        assertEquals("pres1001", result.getPrescriptionId());
        assertEquals("app001", result.getAppointmentId());
        assertEquals("fever", result.getDescription());
        assertEquals("swathi", result.getPatientName());
        assertEquals("San", result.getDoctorName());
    }


}
