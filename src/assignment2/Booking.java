/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.io.Serializable;

/**
 *
 * @author Viet Long
 */

public class Booking implements Serializable{
    
    private String bcode;
    private String ccode;
    private int seat;
    public static final long serialVersionUID = 1L;

    public Booking() {
    }

    public Booking(String bcode, String ccode, int seat) {
        this.bcode = bcode;
        this.ccode = ccode;
        this.seat = seat;
    }
    
    //function get Bus code
    public String getBcode() {
        return bcode;
    }
    
    //function set Bus code
    public void setBcode(String tcode) {
        this.bcode = tcode;
    }
    
    //function get Customer code
    public String getCcode() {
        return ccode;
    }
    
    //function set Customer code
    public void setCcode(String ccode) {
        this.ccode = ccode;
    }
    
    //function get Seat
    public int getSeat() {
        return seat;
    }
    
    //function set Seat
    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Booking{" + "bcode=" + bcode + ", ccode=" + ccode + ", seat=" + seat + '}';
    }
    
    
}
