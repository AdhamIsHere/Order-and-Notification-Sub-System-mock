package com.example.SDA_2.Controller;

import com.example.SDA_2.Data.CustomerDatabase;
import com.example.SDA_2.Models.Customer;
import com.example.SDA_2.Models.Response;
import com.example.SDA_2.Services.AccountServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    Customer loggedin;
    @Autowired
    AccountServiceImp accountService;
    @PostMapping("/add")
    public Response addCustomer(@RequestBody Customer c) {
        System.out.println("in add Customer"+c);
        boolean res = accountService.SignUp(c);
        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("Customer Already Exists");
            return response;
        }

        response.setStatus(true);
        response.setMessage("Customer created successfully");
        return response;
    }
    @GetMapping("/get")
    public Customer[] getAll(){
        System.out.println("In get all customers");
        return accountService.getAll();
    }
    @GetMapping("/get/{un}")
    public Customer getByUsername(@PathVariable("un") String un){
        System.out.println("In get by username"+un);
        return CustomerDatabase.getCustomerByUsername(un);
    }
    @GetMapping("/login/{un}/{pw}")
    public Response login(@PathVariable("un") String un,@PathVariable("pw") String pw) {
        System.out.println("In Login "+un+" "+pw);
        loggedin = CustomerDatabase.getCustomerByUsernameAndPassword(un,pw);
        Response res = new Response();
        if(loggedin == null){
            res.setStatus(false);
            res.setMessage("Check Username and Password");
        }else {
            res.setStatus(true);
            res.setMessage("Logged in Successfully");
        }
        return res;
    }
}
