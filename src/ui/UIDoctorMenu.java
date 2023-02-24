
package ui;

import java.util.ArrayList;
import java.util.Scanner;
import model.Doctor;

public class UIDoctorMenu {
    
    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();//Array con doctores con citas disponibles
    public static void showDoctorMenu(){
        
       //UIMenu.doctorLogged.addAvailableAppointment("","");
        int response = 0;
        do {            
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome "+UIMenu.doctorLogged.getName());
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
                     checkDoctorAvailableAppointments(UIMenu.doctorLogged);
                    break;
                 case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    throw new AssertionError();
            }
            
        } while (response !=0);
    }
    private static void show_Add_Available_Appointments_Menu(){
        int response =0;
        do {            
            System.out.println(":: Add Available Appointment");
            System.out.println(":: Select a Month");
            for (int i = 0; i < 3; i++) {
                int j = i+1;
                System.out.println(j+". "+ UIMenu.MONTHS[i]);
            }
            System.out.println("0. Return");
            
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            
            if (response >0 && response<4) {
                //1,2,3
                int monthSelected = response;
                System.out.println(monthSelected+". "+ UIMenu.MONTHS[monthSelected-1]+" Selected");
                
                int responseDate = 2;
                String date;
                
                do {                    
                    System.out.println("Insert the date available: [dd/mm/yyyy]");
                    date= sc.nextLine();
                    System.out.println("Your date is: "+date+ "\n1. Correct \n2. Change date");
                    responseDate=Integer.valueOf(sc.nextLine());
                } while (responseDate==2);
                
                
                int responseTime =2;
                String time;
                do {
                    System.out.println("Insert the time available: [00:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is: "+time+ "\n1. Correct \n2. Change time");
                    responseTime = Integer.valueOf(sc.nextLine());
                } while (responseTime==2);
                System.out.println("-------Successful add appointment-------");
                UIMenu.doctorLogged.addAvailableAppointment(date, time);
                checkDoctorAvailableAppointments(UIMenu.doctorLogged);
                
            } else if (response ==0){
                showDoctorMenu();
            }
            
        } while (response !=0);
    }
    
    //Envia el doctor con cita al array de doctores con citas,  validando que no estuviera en el array antes de 
    private static void checkDoctorAvailableAppointments (Doctor doctor){
        if (doctor.getAvailableAppointments().size()>0 &&
                !doctorsAvailableAppointments.contains(doctor)) {
            doctorsAvailableAppointments.add(doctor);
        }
    }
}
