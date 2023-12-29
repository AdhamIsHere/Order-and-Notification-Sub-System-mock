package com.example.SDA_2.Data;

import com.example.SDA_2.Models.Customer;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomerDatabase {
    static ArrayList<Customer> customers = new ArrayList<>(Arrays.asList(new Customer("ahmed", "ahmed11", "ahmed1554", 500),
            new Customer("ahmed1", "ahmed12", "ahmed1554", 500),
            new Customer("ahmed2", "ahmed13", "ahmed1554", 5000)));

    CustomerDatabase() {

    }

    public static Boolean addCustomer(Customer c) {
        if (customers.contains(c)) {
            return false;
        }
        customers.add(c);
        return true;

    }

    public static void removeCustomer(Customer c) {
        customers.remove(c);
    }

    public static Customer getCustomerByUsername(String un) {
        for (Customer i : customers) {
            if (i.getUserName().equals(un)) return i;
        }
        return null;
    }

    public static Customer getCustomerByUsernameAndPassword(String un, String pw) {
        for (int i=0;i<customers.size();i++) {
            if (customers.get(i).getUserName().equals(un) && customers.get(i).getPassword().equals(pw)) return customers.get(i);
        }
        return null;
    }

    public static Customer[] getAllCustomers() {
        return customers.toArray(new Customer[0]);
    }
}
