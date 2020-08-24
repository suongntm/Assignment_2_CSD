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

public class BookingList implements Serializable {
    static MyLinkedList<Booking> bookingsList = new MyLinkedList<>();
    
    //input bus's code, customer's code and number of seat
    public Booking input() {
        Booking booking = new Booking();
        Bus bus;
        String ccode = "", bcode;
        int seat = 0;
        do {
            do {
                System.out.print("Enter bus's code: ");
                bcode = Validation.checkInputString();
                bus = BusList.searchByBCode(bcode);
                if (bus == null) {
                    System.err.println("Bus code is not found in bus list");
                }
            } while (bus == null);
            if (bus.getSeat() == bus.getBooker()) {
                System.out.println("Bus is exhausted");
                continue;
            }
            do {
                System.out.print("Enter customer's code: ");
                ccode = Validation.checkInputString();
                if (CustomerList.checkcCodeExist(ccode)) {
                    System.err.println("Customer code is not found in bus list");
                }
            } while (CustomerList.checkcCodeExist(ccode));
            if (!checkExistBooking(bcode, ccode)) {
                System.out.println("This booking is exist in the list");
                continue;
            }
            do {
                System.out.print("Enter number of seat: ");
                seat = Validation.checkInputInt();
                if (seat > bus.getSeat() - bus.getBooker()) {
                    System.out.println("Number of seat avalible is " + (bus.getSeat() - bus.getBooker()));
                }
            } while (seat > bus.getSeat() - bus.getBooker());

        } while (!checkExistBooking(bcode, ccode) || bus.getSeat() == bus.getBooker() || seat > bus.getSeat() - bus.getBooker());
        booking.setBcode(bcode);
        booking.setCcode(ccode);
        booking.setSeat(seat);
        return booking;
    }
    
    //function add booking
    public void addBooking() {
        bookingsList.addFirst(input());
    }
    
    //function display Buscode, Customercode, Seat
    public void display() {
        System.out.println("");
        System.out.println("--------------------------");
        System.out.printf("%9s|%12s|%4s\n", "Buscode", "Customercode", "Seat");
        for (Booking b : bookingsList) {
            System.out.printf("%-9s|%-12s|%-4s\n", b.getBcode(), b.getCcode(), b.getSeat());
        }
        System.out.println("--------------------------");
        System.out.println("");
    }
    
    //function check exist booking
    public static boolean checkExistBooking(String bcode, String ccode) {
        for (Booking book : bookingsList) {
            if (bcode.equalsIgnoreCase(book.getBcode()) && ccode.equalsIgnoreCase(book.getCcode())) {
                return false;
            }
        }
        return true;
    }
}
