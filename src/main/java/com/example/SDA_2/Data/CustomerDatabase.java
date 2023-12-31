package com.example.SDA_2.Data;

import com.example.SDA_2.Models.Customer;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomerDatabase
{
    private ArrayList<Customer> customers;
    private static CustomerDatabase Customerinstance =null;
    private CustomerDatabase()
    {
        customers = new ArrayList<>(Arrays.asList
                (new Customer("ahmed", "ahmed1", "ahmed123", 1000),
                new Customer("adham", "adham1", "adham123", 20000),
                new Customer("tamer", "tamer1", "tamer123", 25000)));
    }


        public static CustomerDatabase getCustomerinstance()
        {
        if (Customerinstance == null)
        {
            Customerinstance = new CustomerDatabase();
        }
        return Customerinstance;
        }


    public  Boolean addCustomer(Customer c)
    {
        if (customers.contains(c))
        {
            return false;
        }
        customers.add(c);
        return true;

    }

    public  void removeCustomer(Customer c)
    {
        customers.remove(c);
    }

    public  Customer getCustomerByUsername(String un)
    {
        for (Customer i : customers)
        {
            if (i.getUserName().equals(un)) return i;
        }
        return null;
    }

    public  Customer getCustomerByUsernameAndPassword(String un, String pw)
    {
        for (Customer customer : customers)
        {
            if (customer.getUserName().equals(un) && customer.getPassword().equals(pw)) return customer;
        }
        return null;
    }

    public  Customer[] getAllCustomers()
    {
        return customers.toArray(new Customer[0]);
    }
}
