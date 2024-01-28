package com.furmi.service;

import com.furmi.Tools.ReadWrite;

import java.util.Scanner;

public class StudioService {


    private static Scanner sc = new Scanner(System.in);
    private static Studio studio = new Studio();
    private static StudioDataScanner sdc = new StudioDataScanner();
    public static void main(String[] args) {
        Option option = new Option();
        ReadWrite read = new ReadWrite();
        read.checkOrCreateFile();
        option.Loop();

    }
    static class Option {
        private final int EXIT = 0;
        private final int REGISTER = 1;
        private final int FIND = 2;
        private final int SHOW = 3;
        private final int HOW_MANY_PATIENTS = 4;
        Option (){}

        public void Loop (){
            int option = 5;
            System.out.println("Weclome in our studio! :)");
            do {
                printOptions();
                option = sc.nextInt();
                switch (option){
                    case EXIT -> studio.exit();
                    case REGISTER -> studio.registerServiceForPatient((studio.addPatientToBase(sdc.createPatientData())),sdc.createServiceData());
                    case FIND -> studio.findPatient(sdc.createPatientDataToFind());
                    case SHOW -> studio.printPatientsList();
                    case HOW_MANY_PATIENTS -> studio.howManyPatientsToday();
                    default -> throw new IllegalStateException("Unexpected value: " + option);
                }

            }while (option != 0);
        }
        private void printOptions (){
            System.out.println("Enter option: ");
            System.out.println("0 - exit ");
            System.out.println("1 - register patient");
            System.out.println("2 - find patient");
            System.out.println("3 - show all patients list");
            System.out.println("4 - show how many patients registered today");
        }
    }
}
