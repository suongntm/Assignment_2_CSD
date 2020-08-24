/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author Viet Long
 */

public class Menu {
    public static int Main() {
        System.out.println("-----------Main Menu-----------");
        System.out.println("Press 1: Manager Bus");
        System.out.println("Press 2: Manager Customer");
        System.out.println("Press 3: Manager Booking");
        System.out.println("Press 4: Exit");
        System.out.println("--------------------------------");
        System.out.print("Enter your choice: ");
        return Validation.checkInputInt();
    }

    public static int Bus() {
        System.out.println("------------Bus Management------------");
        System.out.println("Press 1: Load bus list from file");
        System.out.println("Press 2: Add a bus");
        System.out.println("Press 3: In-order traverse");
        System.out.println("Press 4: Breadth-first traverse");
        System.out.println("Press 5: In-order traverse to file");
        System.out.println("Press 6: Search by bcode");
        System.out.println("Press 7: Delete by bcode by copying");
        System.out.println("Press 8: Simply balancing");
        System.out.println("Press 9: Count number of buses");
        System.out.println("Press 10: Back to main menu");
        System.out.println("---------------------------------------");
        System.out.print("Enter your choice: ");
        return Validation.checkInputInt();
    }

    public static int Customer() {
        System.out.println("----------Customer Management----------");
        System.out.println("Press 1: Load customer list from file");
        System.out.println("Press 2: Add a customer");
        System.out.println("Press 3: Display customer list");
        System.out.println("Press 4: Save customer list to file");
        System.out.println("Press 5: Search customer by ccode");
        System.out.println("Press 6: Delete customer by ccode");
        System.out.println("Press 7: Back to main menu");
        System.out.println("----------------------------------------");
        System.out.print("Enter your choice: ");
        return Validation.checkInputInt();
    }

    public static int Booking() {
        System.out.println("--------Booking Management--------");
        System.out.println("Press 1: Add a booking");
        System.out.println("Press 2: Display booking list");
        System.out.println("Press 3: Sort by bcode + ccode");
        System.out.println("Press 4: Back to main menu");
        System.out.println("----------------------------------");
        System.out.print("Enter your choice: ");
        return Validation.checkInputInt();
    }
}
