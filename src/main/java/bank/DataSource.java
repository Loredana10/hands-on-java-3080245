package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//class to connect to the database, as well as reading and writing from it
public class DataSource {

  public static Connection connect() {
    String db_file = "jdbc:sqlite:resources/bank.db";
    Connection connection = null;
    
    try{
      connection = DriverManager.getConnection(db_file);
      System.out.println("We're connected");
    } catch(SQLException e){
      e.printStackTrace();
    }

    return connection;
    
  }

  public static Customer getCustomer(String username){
    //query to get username from database
    //question mark serves as a place holder
    String sql = "select * from customers where username = ?";
    Customer customer = null;

    //try with resources to connect to the database
    try(Connection connection = connect(); PreparedStatement statement = connection.prepareStatement(sql)){
      statement.setString(1, username);
      try(ResultSet resultSet = statement.executeQuery()){
        customer = new Customer(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("username"), resultSet.getString("password"), resultSet.getInt("account_id"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return customer;
  }

  public static void main(String[] args){
    //main class
    //retrieve a customers details and printing out their name using getName()
    Customer customer = getCustomer("twest8o@friendfeed.com");

    System.out.println(customer.getName());
  }
}
