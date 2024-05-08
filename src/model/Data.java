/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edwimeca
 */
public class Data {

    public static Patient p1 = new Patient("p1", "p1.com");
    public static Patient p2 = new Patient("p2", "p2.com");
    public static Patient p3 = new Patient("p3", "p3.com");
    public static Patient p4 = new Patient("p4", "p4.com");
    public static Patient p5 = new Patient("p5", "p5.com");
    public static Patient p6 = new Patient("p6", "p6.com");
    
    public static Nurse n1 = new Nurse("n1", "n1.com","Inyectology");
    public static Nurse n2 = new Nurse("n2", "n2.com","Inyectology");
    public static Nurse n3 = new Nurse("n3", "n3.com","Inyectology");
    public static Nurse n4 = new Nurse("n4", "n4.com","Inyectology");
    public static Nurse n5 = new Nurse("n5", "n5.com","Inyectology");
    public static Nurse n6 = new Nurse("n6", "n6.com","Inyectology");
    
    public static Doctor d1 = new Doctor("d1", "d1.com");
    public static Doctor d2 = new Doctor("d2", "d2.com");
    public static Doctor d3 = new Doctor("d3", "d3.com");
    public static Doctor d4 = new Doctor("d4", "d4.com");
    public static Doctor d5 = new Doctor("d5", "d5.com");
    public static Doctor d6 = new Doctor("d6", "d6.com");
    
    public static AvailableAppointment a1 = new AvailableAppointment("01/01/2028", "23:00");
    public static AvailableAppointment a2 = new AvailableAppointment("01/01/2028", "23:00");
    public static AvailableAppointment a3 = new AvailableAppointment("01/01/2028", "23:00");
    public static AvailableAppointment a4 = new AvailableAppointment("01/01/2028", "23:00");
    public static AvailableAppointment a5 = new AvailableAppointment("01/01/2028", "23:00");
    public static AvailableAppointment a6 = new AvailableAppointment("01/01/2028", "23:00");
    
    public static List <AvailableAppointment> availableAppointments = new ArrayList<>();
    public static List <Doctor> doctors = new ArrayList<>();
    public static List <Patient> patiens = new ArrayList<>();
    public static List <Nurse> nurses = new ArrayList<>();
    
    public static void createData (){
        createAvailableAppointments();
        createDoctors();
        createPatients();
        createNurses();
    }



    private static void createAvailableAppointments(){
        availableAppointments.add(new AvailableAppointment("01/01/2028", "23:00"));
        availableAppointments.add(new AvailableAppointment("01/01/2028", "23:00"));
        availableAppointments.add(new AvailableAppointment("01/01/2028", "23:00"));
        availableAppointments.add(new AvailableAppointment("01/01/2028", "23:00"));
        availableAppointments.add(new AvailableAppointment("01/01/2028", "23:00"));
        availableAppointments.add(new AvailableAppointment("01/01/2028", "23:00"));
    }

    private static void createDoctors(){
        doctors.add(d1);
        doctors.add(d2);
        doctors.add(d3);
        doctors.add(d4);
        doctors.add(d5);
        doctors.add(d6);            

        for (Doctor doctor : doctors) {
            doctor.addObjAvailableAppointment(a1);
            doctor.addObjAvailableAppointment(a2);
            doctor.addObjAvailableAppointment(a3);
            doctor.addObjAvailableAppointment(a4);
            doctor.addObjAvailableAppointment(a5);
            doctor.addObjAvailableAppointment(a6);
        }        
    }

    private static void createPatients(){
        patiens.add(p1);
        patiens.add(p2);
        patiens.add(p3);
        patiens.add(p4);
        patiens.add(p5);
        patiens.add(p6);

        for (Patient patient : patiens) {
            patient.addAppointmentDoctors(d1, "01/01/2028", "23:00");
            patient.addAppointmentNurses(n1, "01/01/2028", "23:00");
        }        
    }

    private static List<Nurse> createNurses(){
        nurses.add(n1);
        nurses.add(n2);
        nurses.add(n3);
        nurses.add(n4);
        nurses.add(n5);
        nurses.add(n6);



        for (Nurse nurse : nurses) {
            nurse.addObjAvailableAppointment(a1);
            nurse.addObjAvailableAppointment(a2);
            nurse.addObjAvailableAppointment(a3);
            nurse.addObjAvailableAppointment(a4);
            nurse.addObjAvailableAppointment(a5);
            nurse.addObjAvailableAppointment(a6);
        }
        return nurses;   
    }  

    public static List<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }

    public static List<Doctor> getDoctors() {
        return doctors;
    }

    public static List<Patient> getPatiens() {
        return patiens;
    }

    public static List<Nurse> getNurses() {
        return nurses;
    }   
    
        
}
