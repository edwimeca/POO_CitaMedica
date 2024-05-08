
package ui;
import java.util.List;
import java.util.Scanner;
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
            sc.close();

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
       
    }
    
    private static void authUser(int userType){
        //userType =1 Doctor
        //userType =2 Patient
        //userType =3 Nurce
        
        
        List<Doctor> doctors = Data.getDoctors();
        List<Patient> patients = Data.getPatiens();
        List<Nurse> nurses = Data.getNurses(); 
           
        boolean emailcorrect = false;
        
        do {            
            System.out.println("Insert your email: [a@a.com...]");
            //String email = JOptionPane.showInputDialog("Insert your email: [a@a.com...]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            sc.close();
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
