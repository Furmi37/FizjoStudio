package com.furmi.service;

import com.furmi.Tools.ReadWrite;
import com.furmi.data.Patient;
import com.furmi.data.Service;
import com.furmi.data.Sickness;

import java.util.Scanner;

public class StudioDataScanner {
    Studio studio = new Studio();
    Sickness sickness = new Sickness();
    int patientNumber = studio.getPatientNumber();
    private Scanner sc = new Scanner(System.in);
    private ReadWrite readWrite = new ReadWrite();

    public Patient createPatientData() {
        System.out.println("Enter patient first name ");
        String firstName = sc.nextLine();
        System.out.println("Enter patient last name: ");
        String lastName = sc.nextLine();
        patientNumber++;
        return new Patient(firstName, lastName, sickness.addSickness());
    }

    public Patient createPatientDataToFind() {
        System.out.println("Enter patient first name ");
        String firstName = sc.nextLine();
        System.out.println("Enter patient last name: ");
        String lastName = sc.nextLine();
        patientNumber++;
        return new Patient(firstName, lastName);
    }
    public Patient setServiceToPatient (Patient patient){
        try {
            printServices();
            String service = sc.nextLine();

            switch (service.toLowerCase()) {
                case "massage" -> {
                    System.out.println("Registered for massage");
                    patient.setService(Service.MASSAGE);
                }
                case "training" -> {
                    System.out.println("Registered for trainging");
                    patient.setService(Service.TRAINING);
                }
                case "phisioterapist consultation" -> {
                    System.out.println("Registered for consultaion");
                    patient.setService(Service.PHISIOTERAPIST_CONSULTATION);
                }
                default -> System.out.println("Wrong option or missclick");
            }
        } catch (IllegalStateException e) {
            System.out.println("You cant use numbers here only letters");
        }
        return patient;
    }
    private void printServices() {
        System.out.println("Which type of service you want register for?");
        System.out.println("We offer massage/training/phisioterapist consultation");
    }
}
