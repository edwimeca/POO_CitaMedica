/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author edwimeca
 */
public class AvailableAppointment  {

    private int id_available_appointment;
    private Date date;
    private String time;
    SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");

    public AvailableAppointment(String date, String time) {
        try {
            this.date = format.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.time = time;
    }

    public int getId_available_appointment() {
        return id_available_appointment;
    }

    public void setId_available_appointment(int id_available_appointment) {
        this.id_available_appointment = id_available_appointment;
    }

    public Date getDate(String DATE) {
        return date;
    }

    public String getDate() {
        return format.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Available Appointment \nDate: " + date + "\nTime: " + time;
    }
}
