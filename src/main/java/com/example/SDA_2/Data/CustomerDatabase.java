package com.example.SDA_2.Data;

import java.util.*;


import com.example.SDA_2.Models.Customer;
import com.example.SDA_2.Models.Notification.Channel.EmailNotificationChannel;
import com.example.SDA_2.Models.Notification.Channel.NotificationChannel;
import com.example.SDA_2.Models.Notification.Channel.SMSNotificationChannel;


public class CustomerDatabase {
    private ArrayList<Customer> customers;
    private static CustomerDatabase Customerinstance = null;
    public static Map<String, NotificationChannel> messageChannels = new HashMap<String, NotificationChannel>();

    private CustomerDatabase() {
        customers = new ArrayList<>(Arrays.asList
                (new Customer("ahmed", "ahmed1", "ahmed123", 999999, "arabic", "sms"),
                        new Customer("adham", "adham1", "adham123", 999999, "english", "email"),
                        new Customer("tamer", "tamer1", "tamer123", 999999, "arabic", "sms")));
    }

    static {
        messageChannels.put("sms", new SMSNotificationChannel());
        messageChannels.put("email", new EmailNotificationChannel());
    }




    public static CustomerDatabase getCustomerinstance() {
        if (Customerinstance == null) {
            Customerinstance = new CustomerDatabase();
        }
        return Customerinstance;
    }


    public Boolean addCustomer(Customer c) {
        if (customers.contains(c)) {
            return false;
        }
        customers.add(c);
        return true;

    }

    public void removeCustomer(Customer c) {
        customers.remove(c);
    }

    public Customer getCustomerByUsername(String un) {
        for (Customer i : customers) {
            if (i.getUserName().equals(un)) return i;
        }
        return null;
    }

    public Customer getCustomerByUsernameAndPassword(String un, String pw) {
        for (Customer customer : customers) {
            if (customer.getUserName().equals(un) && customer.getPassword().equals(pw)) return customer;
        }
        return null;
    }

    public Customer[] getAllCustomers() {
        return customers.toArray(new Customer[0]);
    }
}
