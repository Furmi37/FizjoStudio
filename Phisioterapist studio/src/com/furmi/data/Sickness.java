package com.furmi.data;

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
