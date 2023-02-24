/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.util.ArrayList;
import java.util.Scanner;
import model.Nurse;

/**
 *
 * @author edwimeca
 */
public class UINurseMenu {

    public static ArrayList<Nurse> nurseAvailableAppointments = new ArrayList<>();
    
    

    public static void showNurseMenu() {

        int response = 0;

        do {
            System.out.println("\n\n");
            System.out.println("Nurce");
            System.out.println("Welcome " + UIMenu.nurseLogged.getName());
            System.out.println("1. Add available appointment");
            System.out.println("2. My Schuduled appointmets");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    show_Add_Available_Appointments_Menu();
                    break;
                case 2:
                    showAvailableAppointmentsNurse();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    throw new AssertionError();
            }

        } while (response != 0);

    }

    public static void show_Add_Available_Appointments_Menu() {

        int responseDate = 0;
        int responseTime = 0;
        String date = "";
        String time = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(":: Add Available Appointment");
            System.out.println("Insert the date available: [dd/mm/yyyy]");
            date = sc.nextLine();
            System.out.println("Your date is: " + date + "\n1. Correct \n2. Change date");
            responseDate = Integer.valueOf(sc.nextLine());

        } while (responseDate == 2);

        do {
            System.out.println(":: Add Available Time");
            System.out.println("Insert Available Time: [24:00]");
            time = sc.nextLine();
            System.out.println("Your Time is: " + time + "\n1. Correct \n2. Change date");
            responseTime = Integer.valueOf(sc.nextLine());

        } while (responseTime == 2);
        System.out.println("-------Successful add appointment-------");
        UIMenu.nurseLogged.addAvailableAppointment(date, time);
        checkNurseAvailableAppointments(UIMenu.nurseLogged);
        showNurseMenu();
    }

    public static void checkNurseAvailableAppointments(Nurse nurse) {
        if (!nurseAvailableAppointments.contains(nurse)) {
            nurseAvailableAppointments.add(nurse);
        }
    }

    public static void showAvailableAppointmentsNurse() {
        if (UIMenu.nurseLogged.getAvailableAppointments().size() > 0) {
            System.out.println("\n::Yours Available Appointmens Are:");
            int j = 0;
            for (int i = 0; i < UIMenu.nurseLogged.getAvailableAppointments().size(); i++) {
                j = i + 1;
                System.out.println(j + ". Date: " + UIMenu.nurseLogged.getAvailableAppointments().get(i).getDate()
                        + " Time " + UIMenu.nurseLogged.getAvailableAppointments().get(i).getTime());
            }

        }else{
            System.out.println("You do not have Available Appointments");
        }
    }
}
