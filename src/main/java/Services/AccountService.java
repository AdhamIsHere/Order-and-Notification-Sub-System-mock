package Services;

import Models.Customer;

public interface AccountService {
    public Customer SignIn(String un, String pw);
    public boolean SignUp(String un,String pw , float balance);
}
