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
 * @author Hi
 */
public class CustomerList implements Serializable {
    static MyLinkedList<Customer> customersList = new MyLinkedList<>();

    public Customer input() {
        Customer customer = new Customer();
        String ccode;
        do {
            System.out.print("Enter customer's code: ");
            ccode = Validation.checkInputString();
            if (!checkcCodeExist(ccode)) {
                System.err.println("Customer code is exist in the list");
            }
        } while (!checkcCodeExist(ccode));
        customer.setCcode(ccode);
        System.out.print("Enter customer name: ");
        customer.setCus_name(Validation.checkInputString());
        System.out.print("Enter phone number: ");
        customer.setPhone(Validation.checkInputString());
        return customer;
    }
    
    public void addTest() {
        customersList.addLast(new Customer("C03", "Hoa", "1902"));
        customersList.addLast(new Customer("C01", "La", "1901"));
    
    }

    public void addCustomer() {
        customersList.addLast(input());
    }

    public void display() {
        System.out.println("");
        
        System.out.println("-------------------------");
        System.out.printf("%5s|%13s|%4s\n", "ccode", "Customer_name", "Phone");
        System.out.println("-------------------------");
        for (Customer a : customersList) {
            System.out.printf("%-5s|", a.getCcode());
            System.out.printf("%-13s|", a.getCus_name());
            System.out.printf("%-4s", a.getPhone());
            System.out.println("");
        }
        System.out.println("-------------------------");
        System.out.println("");
    }

    public void deleteByCCode() {
        System.out.print("Enter customer code to delete: ");
        String tcode = Validation.checkInputString();
        for (Customer c : customersList) {
            if (tcode.equalsIgnoreCase(c.getCcode())) {
                customersList.deleteNode(c);
                System.out.println("Delete success");
                return;
            }
        }
        System.out.println("Dont have this customer in list");
    }

    public void searchByCCode() {
        System.out.print("Enter customer code to search: ");
        String tcode = Validation.checkInputString();
        for (Customer c : customersList) {
            if (tcode.equalsIgnoreCase(c.getCcode())) {
                System.out.println(c.toString());
                return;
            }
        }
        System.out.println("Dont have this customer in list");
    }

    public void saveToFile() throws FileNotFoundException {
        //save object to binary file
        try {
            FileOutputStream fos = new FileOutputStream("customer.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(customersList);
            oos.close();
        } catch (Exception e) {
        }

        //save view file
        PrintWriter pw = new PrintWriter(new FileOutputStream("customer.txt"));
        for (Customer c : customersList) {
            String tmp = c.toString();
            pw.write(tmp);
        }
        pw.close();
    }

    public void loadFromFile() {
        String file = "customer.dat";
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            customersList = (MyLinkedList) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Dont have this file");
        }
    }

    public static boolean checkcCodeExist(String ccode) {
        for (Customer customer : customersList) {
            if (ccode.equalsIgnoreCase(customer.getCcode())) {
                return false;
            }
        }
        return true;
    }
}
