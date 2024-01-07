package com.furmi.service;

import com.furmi.Tools.ReadWrite;

import java.util.Scanner;

public class StudioService {

    /*
    README!!!
    It is a program which will help to organize as a Phisioterapist. It is a demo version. In this programm you can add patients that will
    come to you today, and you can register them to your service, find them or print their list. They are also moved to document. Every single
    day is seperated in doc beetwen the lines (for demo version every exit of program ends a day and puts line). You have list of patients only
    added today, but in doc you can see every patient from the begining.
     */
    static Scanner sc = new Scanner(System.in);
    static Studio studio = new Studio();
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
            System.out.println("Weclome to our studio! :)");
            do {
                printOptions();
                option = sc.nextInt();
                switch (option){
                    case EXIT -> studio.exit();
                    case REGISTER -> studio.registerPatient(studio.readAndCreatePatient());
                    case FIND -> studio.findRegisteredPatient();
                    case SHOW -> studio.printPatientsList();
                    case HOW_MANY_PATIENTS -> studio.howManyPatientsToday();
                }

            }while (option != 0);
        }

        private void printOptions (){
            System.out.println("Enter option: ");
            System.out.println("0 - exit ");
            System.out.println("1 - register patient");//dodaj do pliku
            System.out.println("2 - find patient");
            System.out.println("3 - show patients list");//wczytaj z pliku!!
            System.out.println("4 - show how many patients registered today");

            //read from base
        }
    }
}
