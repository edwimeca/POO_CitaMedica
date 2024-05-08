/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author edwimeca
 */
public class Nurse extends  User{
    private String speciality;
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    public Nurse() {
    }    

    public Nurse(String name, String email, String specility) {
        super(name, email);
        this.speciality=specility;
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }
    

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpeciality : "+speciality;
    }

    @Override
    public void showDataUser() {
        System.out.println("Datos propios entre el Dr y el hospital");
    }
    
    public void addAvailableAppointment (String date, String time){
        
        availableAppointments.add(new AvailableAppointment(date,time));
    }
    public void addObjAvailableAppointment(AvailableAppointment availiableAppointmen){
        availableAppointments.add(availiableAppointmen);
    }
    
}
