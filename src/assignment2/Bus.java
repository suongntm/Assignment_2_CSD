package assignment2;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viet Long
 */

public class Bus implements Serializable {
    
    public String bcode;
    public String busName;
    public int seat;
    public int booker;
    public double departTime;
    public String departPlace;
    private static final long serialVersionUID = 1L;

    public Bus() {
    }

    public Bus(String bcode, String busName, int seat, int booker, double departTime, String departPlace) {
        this.bcode = bcode;
        this.busName = busName;
        this.seat = seat;
        this.booker = booker;
        this.departTime = departTime;
        this.departPlace = departPlace;
    }
    
    //function get Bus code
    public String getBcode() {
        return bcode;
    }
    
    //function set Bus code
    public void setBcode(String bcode) {
        this.bcode = bcode;
    }
    
    //funcrion get Bus name
    public String getBusName() {
        return busName;
    }
    
    //function set Bus name
    public void setBusName(String busName) {
        this.busName = busName;
    }
    
    //function get Seat
    public int getSeat() {
        return seat;
    }
    
    //function set Seat
    public void setSeat(int seat) {
        this.seat = seat;
    }
    
    //function get Booker
    public int getBooker() {
        return booker;
    }
    
    //function set Booker
    public void setBooker(int booker) {
        this.booker = booker;
    }
    
    //function get DepartTime
    public double getDepartTime() {
        return departTime;
    }
    
    //function set Depart Time
    public void setDepartTime(double departTime) {
        this.departTime = departTime;
    }
    
    //function get Depart Place
    public String getDepartPlace() {
        return departPlace;
    }
    
    //function set Depart Place
    public void setDepartPlace(String departPlace) {
        this.departPlace = departPlace;
    }

    @Override
    public String toString() {
        return String.format("%-5s|%-5s|%-5d|%-5d|%-5.1f|%-5s\n", bcode, busName, seat, booker, departTime, departPlace);
    }
    
}
