package database;

import java.sql.*;

public class Database {
  public static Connection getConnection() {

    try {
      String url = "jdbc:mysql://localhost:3306/StudentManagement";
      String user = "root";
      String password = "garlicbread";
      return DriverManager.getConnection(url, user, password);

    } catch (

    SQLException e) {
      System.err.println("Connection failed: " + e.getMessage());
    }

    return null;
  }
}
