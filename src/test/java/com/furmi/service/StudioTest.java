package com.furmi.service;
//import static org.junit.jupiter.api.Assertions.*;

import com.furmi.data.Patient;
import com.furmi.data.Service;
import com.furmi.data.Sickness;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudioTest {

    @Test
    void shouldAddPatientToList() {
        Studio studio = new Studio();
        Patient patient = new Patient("Monthy", "Python");
        studio.addPatientToBase(patient);

        assertEquals(1, studio.getPatients().size());
    }
    @Test
    void shouldRegisteredPatientForMassage(){
        Studio studio = new Studio();
        Patient patient = new Patient("Monthy", "Python", new Sickness("Back"));
        studio.registerServiceForPatient(patient, "massage");

        assertTrue(patient.getService().equals(Service.MASSAGE));
    }
    @Test
    void shouldFindPatient() {
        Studio studio = new Studio();
        Patient patient = new Patient("Monthy", "Python", new Sickness("Back"));
        studio.addPatientToBase(patient);
        studio.registerServiceForPatient(patient, "training");

        List<Patient> foundList = studio.findPatient(new Patient("Monthy", "Python"));

        assertNotNull(foundList.size());
    }
    @Test
    void shouldBeOnePatientRegisteredToday(){
        Studio studio = new Studio();
        Patient patient = new Patient("Monthy", "Python", new Sickness("Back"));
        studio.addPatientToBase(patient);
        studio.registerServiceForPatient(patient, "training");

        assertEquals(1, studio.getPatientNumber());
    }

}