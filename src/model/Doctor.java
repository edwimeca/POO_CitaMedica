
package model;

import java.util.ArrayList;

public class Doctor extends User {
    private String speciality;
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    
    


    public Doctor(String name, String email){
        super(name,email);
        this.speciality=speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
   
    //Metodo para adherir objetos al array
    public void addAvailableAppointment (String date, String time){
        
        availableAppointments.add(new AvailableAppointment(date,time));
    }
    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }

    public void addObjAvailableAppointment(AvailableAppointment availableAppointments) {
       this.availableAppointments.add(availableAppointments);
    }
    

    @Override
    public String toString() {
        return super.toString() + "\nSpeciality: "+speciality+"\nAvailable: "+availableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Datos propios entre el Dr y el hospital");
        
    }
    
}
