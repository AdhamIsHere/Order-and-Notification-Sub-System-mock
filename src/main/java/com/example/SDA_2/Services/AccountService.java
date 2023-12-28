package com.example.SDA_2.Services;

import com.example.SDA_2.Models.Customer;

public interface AccountService {
    public boolean SignIn(String un, String pw);
    public boolean SignUp(Customer c);
    public Customer[] getAll();
}
