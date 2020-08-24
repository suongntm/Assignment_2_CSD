/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.io.FileNotFoundException;

/**
 *
 * @author macbook
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        int choice, choice1;
        BusList bus = new BusList();
        CustomerList customer = new CustomerList();
        BookingList booking = new BookingList();
        do {
            choice = Menu.Main();
            switch (choice) {
                case 1:
                    do {
                        choice1 = Menu.Bus();
                        switch (choice1) {
                            case 1:
                                bus.loadFromFile();
                                break;
                            case 2:
                                bus.addBus();
                                break;
                            case 3:
                                bus.display();
                                break;
                            case 4:
                                bus.displayBreadth();
                                break;
                            case 5:
                                bus.saveToFile();
                                break;
                            case 6:
                                bus.searchByBCode();
                                break;
                            case 7:
                                bus.deleteByBcode();
                                break;
                            case 8:
                                bus.balance();
                                break;
                            case 9:
                                bus.getNumberOfBus();
                                break;
                        }
                    } while (choice1 != 10);
                    break;
                case 2:
                    do {
                        choice1 = Menu.Customer();
                        switch (choice1) {
                            case 1:
                                customer.loadFromFile();
                                break;
                            case 2:
                                customer.addCustomer();
                                break;
                            case 3:
                                customer.display();
                                break;
                            case 4:
                                customer.saveToFile();
                                break;
                            case 5:
                                customer.searchByCCode();
                                break;
                            case 6:
                                customer.deleteByCCode();
                                break;
                        }
                    } while (choice1 != 7);
                    break;
                case 3:
                    do {
                        choice1 = Menu.Booking();
                        switch (choice1) {
                            case 1:
                                booking.addBooking();
                                break;
                            case 2:
                                booking.display();
                                break;
                            case 3:
                                
                                break;
                        }
                    } while (choice1 != 4);
                    break;
                case 4:
                    break;
            }
        } while (choice != 4);
    }
    
}
