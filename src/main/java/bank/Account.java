package bank;

import bank.exceptions.AmountException;

public class Account {

  private int id;
  private String type;
  private double balance;

  //constructor
  public Account(int id, String type, double balance){
    setId(id);
    setType(type);
    setBalance(balance);
  }

  public int getId(){
    return this.id;
  }

  public void setId(int id){
    this.id = id;
  }

  public String getType(){
    return this.type;
  }

  public void setType(String type){
    this.type = type;
  }

  public double getBalance(){
    return this.balance;
  }

  public void setBalance(double balance){
    this.balance = balance;
  }

  public void deposit(double amount) throws AmountException{

    //checking if the amount deposited in the account is 0 or negative
    if(amount < 1){
      //created our own exception in the bank.exceptions package
      throw new AmountException("The minimum deposit is 1.00");
    }
    else{
      double newBalance = balance + amount;
      setBalance(newBalance);
      //updating the data base to hold the new balance
      DataSource.updateAccountBalance(id, newBalance);
    }

  }

  public void withdraw(double amount) throws AmountException{
    // checking if the amount deposited in the account is 0 or negative
    if (amount < 0) {
      // created our own exception in the bank.exceptions package
      throw new AmountException("The withdrawal amount must be greater than 0");
    } 
    else if(amount> getBalance()){
      throw new AmountException("You do not have sufficient funds for this withdrawal.");
    }
    
    else 
    {
      double newBalance = balance - amount;
      setBalance(newBalance);
      // updating the data base to hold the new balance
      DataSource.updateAccountBalance(id, newBalance);
    }

  }

}
