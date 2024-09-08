package bank;

import javax.security.auth.login.LoginException;
import javax.xml.crypto.Data;

public class Authenticator {

  public static Customer login(String username, String password) throws LoginException {
    Customer customer = DataSource.getCustomer(username);

    if(customer == null){
      throw new LoginException("Username not found");
    }

    if(password.equals(customer.getPassword())){
      customer.setAuthenticated(true);
      return customer;
    }
    else{
      throw new LoginException("Incorrect Password");
    }

  }

  public static void logout(Customer customer){
    customer.setAuthenticated(false);

  }

}
