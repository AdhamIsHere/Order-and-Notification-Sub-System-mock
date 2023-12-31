package com.example.SDA_2.Services;

import com.example.SDA_2.Data.CustomerDatabase;
import com.example.SDA_2.Models.Customer;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService {

    private CustomerDatabase customerDatabase = CustomerDatabase.getCustomerinstance();
    @Override
    public boolean SignIn(String un, String pw) {
        Customer mycustomer = customerDatabase.getCustomerByUsernameAndPassword(un, pw);
        return (mycustomer != null) ? true : false;


    }

    @Override
    public boolean SignUp(Customer c) {

        return customerDatabase.addCustomer(c);


    }
    @Override
    public Customer[] getAll(){
        return customerDatabase.getAllCustomers();
    }

}
