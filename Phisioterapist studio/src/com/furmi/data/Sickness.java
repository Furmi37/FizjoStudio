package com.furmi.data;

import com.furmi.service.StudioDataScanner;

import java.util.Scanner;

public class Sickness {
    private String sickness;

    public Sickness(String sickness) {
        this.sickness = sickness;
    }
    public Sickness(){}

    @Override
    public String toString() {
        return sickness;
    }


}
