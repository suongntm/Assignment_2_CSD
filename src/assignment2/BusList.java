/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 *
 * @author Viet Long
 */

public class BusList implements Serializable {
    static BinarySearchTree busList;

    public BusList() {
        busList = new BinarySearchTree();
    }
    
    //function add test
    public void addtest() {
        busList.insert(new Bus("B03", "East", 12, 3, 11, "BE"));
        busList.insert(new Bus("B04", "West", 9, 5, 5, "BW"));
        busList.insert(new Bus("B01", "South", 10, 5, 5.7, "BS"));
        busList.insert(new Bus("B02", "North", 5, 2, 4, "BN"));
    }
    
    //function input
    public Bus input() {
        Bus bus = new Bus();
        String code;
        do {
            System.out.print("Enter Bus Code: ");
            code = Validation.checkInputString();
            if (!checktCodeExist(code)) {
                System.err.println("Bus code is exist in list");
            }
        } while (!checktCodeExist(code));
        bus.setBcode(code);
        System.out.print("Enter Bus Name: ");
        bus.setBusName(Validation.checkInputString());
        System.out.print("Enter number of seat: ");
        bus.setSeat(Validation.checkInputPositiveInt());
        //number of booker must be <= number of seat
        System.out.print("Enter number of booker: ");
        bus.setBooker(Validation.checkInputIntLimit(0, bus.getSeat()));
        System.out.print("Enter depart time: ");
        bus.setDepartTime(Validation.checkInputDouble());
        System.out.print("Enter depart place: ");
        bus.setDepartPlace(Validation.checkInputString());
        return bus;
    }
    
    public void addBus() {
        busList.insert(input());
    }

   

    public void display() {
        busList.inOrder(busList.getRoot());
    }

    public void deleteByBcode() {
        System.out.print("Enter bus code to delete: ");
        String tcode = Validation.checkInputString();
        busList.delete(tcode);
    }
    
    public void searchByBCode() {
        System.out.print("Enter bus code to search: ");
        String bcode = Validation.checkInputString();
        Bus bus = busList.search(busList.getRoot(), bcode).info;
        if (bus == null) {
            System.err.println("Dont have that bus in list");
        } else {
            System.out.println(bus.toString());
        }
    }

    public static Bus searchByBCode(String bcode) {
        Bus bus = busList.search(busList.getRoot(), bcode).info;
        return bus;
    }

    public void saveToFile() {
        try {
            FileOutputStream fos = new FileOutputStream("bus.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(busList);
            oos.close();
        } catch (IOException e) {
        }

    }

    public void loadFromFile() {
        try {
            FileInputStream fis = new FileInputStream("bus.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            busList = (BinarySearchTree) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
        }
    }
    
    public void balance() {
        Bus[] trains = busList.sort();
        busList.clear();
        busList.simplyBalance(trains, 0, trains.length - 1);
    }
    
    public void displayBreadth() {
        busList.breadthTraverse();
    }
    
    public void deleteBeforeBus() {
        String bcode;
        System.out.print("Enter bus code: ");
        bcode = Validation.checkInputString();
        //here
    }
    
    boolean checktCodeExist(String code) {
        return busList.search(busList.getRoot(), code) == null;
    }
    
    public void getNumberOfBus() {
        System.out.println("Number of bus in bus list is: " + busList.countNode(busList.getRoot()));
    }


}
