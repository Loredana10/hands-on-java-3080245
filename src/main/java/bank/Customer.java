package bank;

public class Customer {

  private int id;
  private String name;
  private String username;
  private String password;
  private int accountId;

  //constructor
  public Customer(int id, String name, String username, String password, int accountId){
    setId(id);
    setName(name);
    setUsername(username);
    setPassword(password);
    setAccountId(accountId);
  }

  //methods for the fields
  public int getId(){
    return this.id;
  }

  public void setId(int id){
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getAccountId() {
    return this.accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }

}


/*
 * EXPLAINING THE USE OF THE CNSTRUCTOR AND METHODS
 * Great, now we have the fields and the methods for the customer. 
 * However, if we wanted to create a customer object using this class, we need to call quite a few methods in order to set all of the field values. 
 * As a shortcut to set up our data, we can add a constructor to the class. 
 * Constructors are used to initialize an object or set up it's state. We'll make the constructor public so that it can be accessed outside of this class. 
 * The access modifier is followed by the name of the constructor. Which must be the exact same name as the class.
 */