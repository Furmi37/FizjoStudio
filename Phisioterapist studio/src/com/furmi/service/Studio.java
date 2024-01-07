package com.furmi.service;

import com.furmi.data.Patient;
import com.furmi.data.Service;
import com.furmi.data.Sickness;
import com.furmi.Tools.ReadWrite;

import java.util.*;

public class Studio {
    private List<Patient> patients = new ArrayList<>();
    private int patientNumber = 0;

    private Scanner sc = new Scanner(System.in);
    private Sickness sickness = new Sickness();
    private ReadWrite readWrite = new ReadWrite();

    public Patient readAndCreatePatient() {
        System.out.println("Enter first name ");
        String firstName = sc.nextLine();
        System.out.println("Enter last name: ");
        String lastName = sc.nextLine();

        patientNumber++;
        Patient patient = new Patient(firstName, lastName, sickness.addSickness());
        patients.add(patient);
        return patient;
    }

    public void howManyPatientsToday() {
        if (patientNumber == 1) {
            System.out.println("In the studio we have " + patientNumber + " patient registered.");
        } else if (patientNumber == 0) {
            System.out.println("In the studio we have 0 patients registered.");
        }else
            System.out.println("In the studio we have "+ patientNumber + " patient registered.");
    }
    public void exit (){
        System.out.println("Closing the programm, thank you for today!");
        readWrite.writeToFile("-----------------------------------------------------------");
    }

    public void printPatientsList () {
        System.out.println("-----------------------------------------------------------");
            readWrite.readFromFile();
        }

    public void findRegisteredPatient() {
        System.out.println("Who do you want to find?");
        System.out.println("Name: ");
        String firstName = sc.nextLine();
        System.out.println("Lastname: ");
        String lastName = sc.nextLine();
        List<Patient> list = patients.stream()
                .filter(p -> p.getFirstName().equals(firstName) && p.getLastName().equals(lastName))
                .toList();

        if(list.size() > 0){
            list.forEach(System.out::println);
        }else
                System.out.println("There isn't this patient in our base");
        }

    public void registerPatient(Patient patient){
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

            readWrite.writeToFile(String.valueOf(patient));

        }catch (IllegalStateException e){
            System.out.println("You cant use numbers here only letters");
        }
    }
    private void printServices (){
        System.out.println("Which type of service you want register for?");
        System.out.println("We offer massage/training/phisioterapist consultation");
    }
    public void edit (){

    }
}
