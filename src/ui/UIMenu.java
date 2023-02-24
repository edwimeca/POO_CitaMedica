
package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import model.AvailableAppointment;
import model.Data;
import model.Doctor;
import model.Nurse;
import model.Patient;

public class UIMenu {
    public static final String[] MONTHS = {"January","February","March","April","May","June","July","August",
                                     "September","October"};
    
    public static Doctor doctorLogged;
    public static Nurse  nurseLogged;
    public static Patient patientLogged;
    

    public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Selec the desired option");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("3. Nurse");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    response = 0;
                    System.out.println("Doctor");
                    authUser(1);
                    break;
                case 3:
                    response = 0;
                    System.out.println("Nurce");
                    authUser(3);
                    break;
                case 2:
                    response = 0;
                    System.out.println("Patient");
                    authUser(2);
                    break;
                case 0:
                    response=1;
                    System.out.println("Thank you for you visit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
        if (response==1) {
            
            
        }
    }
    
    private static void authUser(int userType){
        //userType =1 Doctor
        //userType =2 Patient
        //userType =3 Nurce
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.addAll(Arrays.asList(Data.d1,Data.d2,Data.d3,Data.d4,Data.d5,Data.d6));
        UIDoctorMenu.doctorsAvailableAppointments.addAll(Arrays.asList(Data.d1,Data.d2,Data.d3,Data.d4,Data.d5,Data.d6));
        
        Data.d1.addObjAvailableAppointment(Data.a1);
        Data.d1.addObjAvailableAppointment(Data.a2);
        Data.d2.addObjAvailableAppointment(Data.a1);
        Data.d2.addObjAvailableAppointment(Data.a2);
        Data.d3.addObjAvailableAppointment(Data.a1);
        Data.d3.addObjAvailableAppointment(Data.a2);
        Data.d4.addObjAvailableAppointment(Data.a1);
        Data.d4.addObjAvailableAppointment(Data.a2);
        Data.d5.addObjAvailableAppointment(Data.a1);
        Data.d6.addObjAvailableAppointment(Data.a2);
        
        ArrayList<Patient> patients = new ArrayList<>();
        patients.addAll(Arrays.asList(Data.p1,Data.p2,Data.p3,Data.p4,Data.p5,Data.p6));
       
        ArrayList<Nurse> nurses = new ArrayList<>();
        nurses.addAll(Arrays.asList(Data.n1,Data.n2,Data.n3,Data.n4,Data.n5,Data.n6));
        UINurseMenu.nurseAvailableAppointments.addAll(Arrays.asList(Data.n1,Data.n2,Data.n3,Data.n4,Data.n5,Data.n6));
        
        Data.n1.addObjAvailableAppointment(Data.a1);
        Data.n1.addObjAvailableAppointment(Data.a2);
        Data.n2.addObjAvailableAppointment(Data.a1);
        Data.n2.addObjAvailableAppointment(Data.a2);
        Data.n3.addObjAvailableAppointment(Data.a1);
        Data.n3.addObjAvailableAppointment(Data.a2);
        Data.n4.addObjAvailableAppointment(Data.a1);
        Data.n4.addObjAvailableAppointment(Data.a2);
        Data.n5.addObjAvailableAppointment(Data.a1);
        Data.n5.addObjAvailableAppointment(Data.a2);
        Data.n6.addObjAvailableAppointment(Data.a1);
        Data.n6.addObjAvailableAppointment(Data.a2);
       
        
        boolean emailcorrect = false;
        
        do {            
            System.out.println("Insert your email: [a@a.com...]");
            //String email = JOptionPane.showInputDialog("Insert your email: [a@a.com...]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            
            switch (userType) {
                case 1:
                    for (Doctor d: doctors) {
                        if (d.getEmail().equals(email)) {
                            emailcorrect=true;
                            //obtener el usuario logueado
                            doctorLogged = d;
                            UIDoctorMenu.showDoctorMenu();
                        }
                    }
                    break;
                case 2:
                    for (Patient p: patients) {
                        if (p.getEmail().equals(email)) {
                            emailcorrect=true;
                            //obtener el usuario logueado
                            patientLogged = p;
                            UIPatientMenu.showPatientMenu();
                        }
                    }
                    break;
                case 3:
                    for (Nurse n: nurses) {
                        if (n.getEmail().equals(email)) {
                            emailcorrect=true;
                            nurseLogged = n;
                            UINurseMenu.showNurseMenu();
                        }
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        } while (!emailcorrect);
    } 

   
    
}
