package com.furmi.data;

import java.util.Scanner;

public class Sickness {
    private String sickness;
    private final Scanner scanner = new Scanner(System.in);

    public Sickness(String sickness) {
        this.sickness = sickness;
    }
    public Sickness(){}

    @Override
    public String toString() {
        return sickness;
    }

    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        this.sickness = sickness;
    }

    public Sickness addSickness (){
        System.out.println("Which body part hurts?");
        return new Sickness(scanner.nextLine());
    }
}
