package database;

import java.sql.*;

public class DBdemo {
  public static void Connection() {

    try {
      String url = "jdbc:mysql://localhost:3306/test";
      String user = "root";
      String password = "garlicbread";
      Connection conn = DriverManager.getConnection(url, user, password);
      System.out.println("Connection successful!");
      Statement stmt = conn.createStatement();
      stmt.executeUpdate("insert into emp (id,name,age) values (2 ,'khoi',20);");
      ResultSet rSet = stmt.executeQuery("select * from emp");

      while (rSet.next()) {
        System.out.println(rSet.getInt(1) + "  " + rSet.getString(2) + "  " + rSet.getString(3));
      }
      conn.close();

    } catch (

    SQLException e) {
      System.err.println("Connection failed: " + e.getMessage());
    }

  }

  public static void main(String[] args) {
    Connection();
  }
}
