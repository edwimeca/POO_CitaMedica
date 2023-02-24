package ui;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import model.AvailableAppointment;
import model.Doctor;
import model.Nurse;

public class UIPatientMenu {

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
        int response = 0;
        do {
            System.out.println("::Book a Doctor appointment");
            //Numeración de la lista de fechas
            //Integer del segundo map -> Indice de la fecha seleccionada
            //[Doctors]
            //1. -doctor1
            //1. fecha 1
            //2. fecha 2...
            //2. doctor2 ...
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                //se crea un array con todas las citas de los doctores que se enceiuntran en el array doctorsAvailableAppointments
                //ArrayList<Doctor.AvailableAppointment> avalableAppointments =
                ArrayList<AvailableAppointment> avalableAppointments
                        = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();
                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

                for (int j = 0; j < avalableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + avalableAppointments.get(j).getDate());
                    //se agregan las citas disponibles a los Map
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);

                }

            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());

            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("", "");

            for (Map.Entry<Integer, Doctor> doc : doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }
            System.out.println(". Doctor Selected: " + doctorSelected.getName() + "\n. Email: " + doctorSelected.getEmail()
                    + "\n. Date: "
                    + doctorSelected.getAvailableAppointments().get(indexDate).getDate()
                    + "\n. Time: "
                    + doctorSelected.getAvailableAppointments().get(indexDate).getTime());
            System.out.println("Comfirm your appointment: \n1. Yes \n2. Change data");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1) {
                UIMenu.patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());
                showPatientMenu();
            }
            System.out.println("Return to the patient menu");
            showPatientMenu();

        } while (response != 0);

    }

    private static void showAddNurseAppointment() {
        int responseNurse = 0;
        int responseAppointement = 0;
        int responseConfirm =0;
        String date= "";
        String time= "";
        String name= "";
        System.out.println("::Book a Nurce appointment");
        Nurse nurseSelected = new Nurse("", "", "");
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Select a Nurse from the following list");
            for (int i = 0; i < UINurseMenu.nurseAvailableAppointments.size(); i++) { 
                int j = i+1;
                System.out.println(j + ". " + UINurseMenu.nurseAvailableAppointments.get(i).getName());

            }
            System.out.println("0. Return");
            
            responseNurse = Integer.valueOf(sc.nextLine());

            nurseSelected = UINurseMenu.nurseAvailableAppointments.get(responseNurse - 1);

        } while (responseNurse == 0);
        
        do {
            System.out.println("\nThe nurse :'" + UINurseMenu.nurseAvailableAppointments.get(responseNurse - 1).getName() + "' has the fallowing available appointments, select one of them please");
            for (int i = 0; i < UINurseMenu.nurseAvailableAppointments.get(responseNurse - 1).getAvailableAppointments().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". Date: " + UINurseMenu.nurseAvailableAppointments.get(responseNurse - 1).getAvailableAppointments().get(i).getDate());
            }
            System.out.println("0. Return");
            responseAppointement = Integer.valueOf(sc.nextLine());
            
        } while (responseAppointement == 0);
        
        do {
            date = nurseSelected.getAvailableAppointments().get(responseAppointement-1).getDate();
            time = nurseSelected.getAvailableAppointments().get(responseAppointement-1).getTime();
            name = nurseSelected.getName();
            System.out.println("Your Nurse Appointment is: ");
            System.out.println("Nurse: "+name);
            System.out.println("Date: "+ date+" Time: "+time);
            System.out.println("\nPlease confirm your appointment.");
            System.out.println("1. yes"+"\n2. No, Return to select Nurse");
            
            responseConfirm = Integer.valueOf(sc.nextLine());
            
            
            
            if (responseConfirm == 1) {
                UIMenu.patientLogged.addAppointmentNurses(
                        nurseSelected,
                        nurseSelected.getAvailableAppointments().get(responseAppointement-1).getDate(null),
                        nurseSelected.getAvailableAppointments().get(responseAppointement-1).getTime());
                showPatientMenu();
            }
            System.out.println("Return to the patient menu");
            showPatientMenu();
            
            
        } while (responseConfirm ==0);

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
