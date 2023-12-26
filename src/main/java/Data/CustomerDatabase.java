package Data;

import Models.Customer;

import java.util.ArrayList;

public class CustomerDatabase {
   static ArrayList<Customer> customers = new ArrayList<>();

    public static Boolean addCustomer(Customer c){
        if(customers.contains(c)){
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
            if(i.getUserName().equals(un)) return i;
        }
        return null;
    }
    public static Customer getCustomerByUsernameAndPassword(String un,String pw){
        for (Customer i : customers) {
            if(i.getUserName().equals(un) && i.getPassword().equals(pw)) return i;
        }
        return null;
    }
}
