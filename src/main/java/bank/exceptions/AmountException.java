package bank.exceptions;

//when creating your own exceptions you can extend from any existing java exceptions
//using "extends" to inherit from java exceptions
public class AmountException extends Exception{

  //constructor
  public AmountException(String message){
    super(message);
  }

}
