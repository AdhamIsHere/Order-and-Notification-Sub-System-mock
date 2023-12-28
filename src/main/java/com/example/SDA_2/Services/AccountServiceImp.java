package com.example.SDA_2.Services;

import com.example.SDA_2.Data.CustomerDatabase;
import com.example.SDA_2.Models.Customer;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService {


    @Override
    public boolean SignIn(String un, String pw) {
        Customer mycustomer = CustomerDatabase.getCustomerByUsernameAndPassword(un, pw);
        return (mycustomer != null) ? true : false;


    }

    @Override
    public boolean SignUp(Customer c) {

        return CustomerDatabase.addCustomer(c);


    }
    @Override
    public Customer[] getAll(){
        return CustomerDatabase.getAllCustomers();
    }

}
