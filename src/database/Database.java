package database;

import java.sql.*;

public class Database {
  public static void DBConnection() {

    try {
      String url = "jdbc:mysql://localhost:3306/test";
      String user = "root";
      String password = "garlicbread";
      Connection conn = DriverManager.getConnection(url, user, password);
      conn.close();

    } catch (

    SQLException e) {
      System.err.println("Connection failed: " + e.getMessage());
    }

  }

  public static void main(String[] args) {
    DBConnection();
  }
}
