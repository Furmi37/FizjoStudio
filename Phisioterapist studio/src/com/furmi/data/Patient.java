package com.furmi.data;

public class Patient extends Person {
    private Sickness sickness;
    private Service service;
    public Patient(String firstName, String lastName, Sickness sickness) {
        super(firstName, lastName);
        this.sickness = sickness;
    }
    public Patient (String firstName, String lastName){
        super(firstName, lastName);
    }
    public Patient(){}

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Sickness getSickness() {
        return sickness;
    }

    public void setSickness(Sickness sickness) {
        this.sickness = sickness;
    }

    @Override
    public String toString() {
        return "Patient: " + getFirstName()+ " " + getLastName() + ", hurts: " + sickness + ", registered for " + service.toString().replace("_", " ").toLowerCase();
    }
}
