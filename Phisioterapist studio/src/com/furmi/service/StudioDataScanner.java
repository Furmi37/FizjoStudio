package com.furmi.service;

import com.furmi.Tools.ReadWrite;
import com.furmi.data.Patient;
import com.furmi.data.Service;
import com.furmi.data.Sickness;

import java.util.Scanner;

public class StudioDataScanner {

    private Sickness sickness = new Sickness();
    private Scanner sc = new Scanner(System.in);
    private ReadWrite readWrite = new ReadWrite();


    public Sickness createSicknessData (){
        System.out.println("Which body part hurts?");
        String sickness = sc.nextLine();
        return new Sickness(sickness);
    }

    public Patient createPatientData() {
        System.out.println("Enter patient first name ");
        String firstName = sc.nextLine();
        System.out.println("Enter patient last name: ");
        String lastName = sc.nextLine();
        Sickness sickness1 = createSicknessData();
        return new Patient(firstName, lastName, sickness1);
    }

    public Patient createPatientDataToFind() {
        System.out.println("Enter patient first name ");
        String firstName = sc.nextLine();
        System.out.println("Enter patient last name: ");
        String lastName = sc.nextLine();

        return new Patient(firstName, lastName);
    }

    public String createServiceData (){
        printServices();
        String service = sc.nextLine();
        return service;
    }


    private void printServices() {
        System.out.println("Which type of service you want register for?");
        System.out.println("We offer massage/training/phisioterapist consultation");
    }
}
