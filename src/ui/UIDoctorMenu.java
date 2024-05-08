
package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.AvailableAppointment;
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
            sc.close();

            switch (response) {
                case 1:
                    show_Add_Available_Appointments_Menu();
                    break;
                 case 2:
                    showAvailableAppointmentsDoctor();
                    break;
                 case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    throw new AssertionError();
            }
            
        } while (response !=0);
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
        sc.close();
        System.out.println("-------Successful add appointment-------");
        UIMenu.doctorLogged.addAvailableAppointment(date, time);
        checkDoctorAvailableAppointments(UIMenu.doctorLogged);
        showDoctorMenu();
    }
    //Envia el doctor con cita al array de doctores con citas,  validando que no estuviera en el array antes de 
    private static void checkDoctorAvailableAppointments (Doctor doctor){
        if (doctor.getAvailableAppointments().size()>0 &&
                !doctorsAvailableAppointments.contains(doctor)) {
            doctorsAvailableAppointments.add(doctor);
        }
    }

    public static void showAvailableAppointmentsDoctor() {
        if (UIMenu.doctorLogged.getAvailableAppointments().size() > 0) {
            System.out.println("\n::Yours Available Appointmens Are:");
            int j = 1;
            for (AvailableAppointment appointment : UIMenu.doctorLogged.getAvailableAppointments()) {
                
                System.out.println(j + ". Date: " + appointment.getDate()
                        + " Time " + appointment.getTime());
                j++;
            }

        }else{
            System.out.println("You do not have Available Appointments");
        }
    }
}
