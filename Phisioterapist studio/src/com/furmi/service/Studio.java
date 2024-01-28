package com.furmi.service;

import com.furmi.data.Patient;
import com.furmi.data.Service;
import com.furmi.data.Sickness;
import com.furmi.Tools.ReadWrite;

import java.util.*;

public class Studio {
    private List<Patient> patients = new ArrayList<>();
    private int patientNumber = 0;

    public List<Patient> getPatients() {
        return patients;
    }

    private Scanner sc = new Scanner(System.in);
    private Sickness sickness = new Sickness();
    private ReadWrite readWrite = new ReadWrite();
    private StudioDataScanner sdc = new StudioDataScanner();

    public int getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(int patientNumber) {
        this.patientNumber = patientNumber;
    }

    public Patient addPatientToBase(Patient patient) {
        patients.add(patient);
        return patient;
    }


    public void howManyPatientsToday() {
        if (patientNumber == 1) {
            System.out.println("In the studio we have " + patientNumber + " patient registered.");
        } else if (patientNumber == 0) {
            System.out.println("In the studio we have 0 patients registered.");
        } else
            System.out.println("In the studio we have " + patientNumber + " patient registered.");
    }

    public void exit() {
        System.out.println("Closing the programm, thank you for today!");
        readWrite.writeToFile("-----------------------------------------------------------");
    }

    public void printPatientsList() {
        System.out.println("-----------------------------------------------------------");
        readWrite.readFromFile();
    }

    public void findPatient(Patient patient) {
        List<Patient> list = patients.stream()
                .filter(p -> p.getFirstName().equals(patient.getFirstName()) && p.getLastName().equals(patient.getLastName()))
                .toList();

        if (list.size() > 0) {
            list.forEach(System.out::println);
        } else
            System.out.println("There isn't this patient in our base");
    }

    public void registerServiceForPatient(Patient patient) {
        sdc.setServiceToPatient(patient);
        readWrite.writeToFile(String.valueOf(patient));
    }


    public void edit() {

    }
}
