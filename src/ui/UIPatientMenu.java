package ui;

import static ui.UIMenu.patientLogged;
import java.util.ArrayList;
import java.util.Scanner;
import model.AvailableAppointment;
import model.Data;
import model.Doctor;
import model.Nurse;
import model.Patient;

public class UIPatientMenu {

    public static ArrayList <Patient> patientsWithDoctorAppointments = new ArrayList<>();
    public static ArrayList <Patient> patientsWithNurceAppointments = new ArrayList<>();

    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient \nWelcome: " + UIMenu.patientLogged.getName());
            System.out.println("1. Book an appointment");
            System.out.println("2. My an appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            sc.close();

            switch (response) {
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyappointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    throw new AssertionError();
            }

        } while (true);
    }

    private static void showBookAppointmentMenu() {

        System.out.println(":: Select type of appointement");
        int dateType = 0;
        do {
            System.out.println("1. Doctor appointment");
            System.out.println("2. Nurse appointment");
            System.out.println("0. Return");
            Scanner sc = new Scanner(System.in);
            dateType = Integer.valueOf(sc.nextLine());
            sc.close();
        } while (dateType == 0);

        switch (dateType) {
            case 1:
                showAddDoctorAppointment();
                break;
            case 2:
                showAddNurseAppointment();
                break;
            default:
                throw new AssertionError();
        }
    }

    private static void showAddDoctorAppointment() {

        System.out.println("\n::Available Doctors \nPlease Select a Doctor");
        Doctor doctorSelected = new Doctor();
        AvailableAppointment availableAppoint = new AvailableAppointment();
         
        int j = 0;
        for (Doctor doctor : Data.doctors) {
            j++;
            System.out.println(j + ". Doctor: " + doctor.getName());
        }
        System.out.println("0. Return");
        Scanner sc = new Scanner(System.in);        
        int responseDoctor = Integer.valueOf(sc.nextLine());
        sc.close();

        if (responseDoctor == 0) {
                showPatientMenu();
        } else {
            doctorSelected = Data.doctors.get(responseDoctor - 1);
            System.out.println("\n::" + doctorSelected.getName() + " Available Appointmens Are:");
            int k = 0;
            for (AvailableAppointment availableAppointment: doctorSelected.getAvailableAppointments()) {
                k++;
                System.out.println(k + ". Date: " + availableAppointment.getDate()
                        + " Time " + availableAppointment.getTime());
            }
        }
        
        System.out.println("0. Return");

        Scanner sc2 = new Scanner(System.in);
        int responseDateSelected = Integer.valueOf(sc2.nextLine());
        sc2.close();
        if (responseDateSelected == 0) {
            showPatientMenu();
        }else{
            availableAppoint = doctorSelected.getAvailableAppointments().get(responseDateSelected - 1);
            patientLogged.addAppointmentDoctors(doctorSelected, availableAppoint.getDate(), availableAppoint.getTime());
            System.out.println("Your appointment has been booked");
            showPatientMenu();
        }      

    }

    private static void showAddNurseAppointment() {

        System.out.println("\n::Available Nurces \nPlease Select a nurce");
        Nurse nurseSelected = new Nurse();
        AvailableAppointment availableAppoint = new AvailableAppointment();
         
        int j = 0;
        for (Nurse nurce : Data.nurses) {
            j++;
            System.out.println(j + ". Nurce: " + nurce.getName());
        }
        System.out.println("0. Return");
        Scanner sc = new Scanner(System.in);        
        int responseNurce = Integer.valueOf(sc.nextLine());
        sc.close();

        if (responseNurce == 0) {
                showPatientMenu();
        } else {
            nurseSelected = Data.nurses.get(responseNurce - 1);
            System.out.println("\n::" + nurseSelected.getName() + " Available Appointmens Are:");
            int k = 0;
            for (AvailableAppointment availableAppointment: nurseSelected.getAvailableAppointments()) {
                k++;
                System.out.println(k + ". Date: " + availableAppointment.getDate()
                        + " Time " + availableAppointment.getTime());
            }
        }
        
        System.out.println("0. Return");

        Scanner sc2 = new Scanner(System.in);
        int responseDateSelected = Integer.valueOf(sc2.nextLine());
        sc2.close();
        if (responseDateSelected == 0) {
            showPatientMenu();
        }else{
            availableAppoint = nurseSelected.getAvailableAppointments().get(responseDateSelected - 1);
            patientLogged.addAppointmentNurses(nurseSelected, availableAppoint.getDate(), availableAppoint.getTime());
            System.out.println("Your appointment has been booked");
            showPatientMenu();
        }      

    }

    private static void showPatientMyappointments() {
        int response = 0;
        do {
            System.out.println("::My Doctors Apponintments");
            if (UIMenu.patientLogged.getAppointmentDoctors().size() == 0) {
                System.out.println("Dont have doctors appointments");
                break;
            }
            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". "
                        + "\nDoctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName()
                        + "\nTime: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime()
                        + "\nDate: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate());
            }
            
            System.out.println("\n::My Nurse Apponintments");
            if (UIMenu.patientLogged.getAppointmentNurses().size() == 0) {
                System.out.println("Dont have Nurses appointments");
                break;
            }
            for (int i = 0; i < UIMenu.patientLogged.getAppointmentNurses().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". "
                        + "\nNurse : " + UIMenu.patientLogged.getAppointmentNurses().get(i).getNurse().getName()
                        + "\nTime: " + UIMenu.patientLogged.getAppointmentNurses().get(i).getTime()
                        + "\nDate: " + UIMenu.patientLogged.getAppointmentNurses().get(i).getDate());
            }
            
            System.out.println("0. Return");
        } while (response != 0);

    }
}
