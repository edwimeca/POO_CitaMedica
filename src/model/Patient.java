/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author edwimeca
 */
public class Patient extends User{
    //Attributes
    private String birthday;
    private String blood;
    private double weight, height;
    
    private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();

    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointment_with_Doctor = new AppointmentDoctor(this, doctor);
        appointment_with_Doctor.schedule(date, time);
        appointmentDoctors.add(appointment_with_Doctor);
    }
    
     public void addAppointmentNurses(Nurse nurse, Date date, String time) {
        AppointmentNurse appointment_with_Nurse = new AppointmentNurse(this, nurse);
        appointment_with_Nurse.schedule(date, time);
        appointmentNurses.add(appointment_with_Nurse);
    }

    public ArrayList<AppointmentNurse> getAppointmentNurses() {
        return appointmentNurses;
    }

    public void setAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }
    
    


    public Patient(String name, String email) {
        super(name,email);

    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    //We are looking for the var always shows Kg
    public String getWeight() {
        return this.weight +" Kg. ";
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return this.height +"mts. ";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Age: "+birthday+ "\n Weight: " +getWeight()+ "\n Height : "
                +getHeight()+"\n Blood : "+blood;
    }

    @Override
    public void showDataUser() {
        System.out.println("Datos del paciente diferentes a los ingresados, no hay relacion con el hospital contractual");
    }
    
    
}
