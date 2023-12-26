package Services;

import Data.CustomerDatabase;
import Models.Customer;

public class AccountServiceImp implements AccountService{



    @Override
    public Customer SignIn(String un, String pw)
    {
        Customer mycustomer = CustomerDatabase.getCustomerByUsernameAndPassword(un, pw);
        return mycustomer ;


    }

    @Override
    public boolean SignUp(String un, String pw, float balance) {
        Customer myCustomer = new Customer();
        myCustomer.setUserName(un);
        myCustomer.setPassword(pw);
        myCustomer.setBalance(balance);
        return CustomerDatabase.addCustomer(myCustomer);


    }
}
