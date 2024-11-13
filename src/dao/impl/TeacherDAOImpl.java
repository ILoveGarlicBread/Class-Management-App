package dao.impl;

import java.sql.*;
import database.Database;
import dao.TeacherDAO;
import model.Teacher;

public class TeacherDAOImpl implements TeacherDAO {

  @Override
  public Teacher authenticateTeacher(String email, String password) {
    String query = "SELECT * FROM teachers WHERE email = ? AND password =?";
    try (Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {

      stmt.setString(1, email);
      stmt.setString(2, password);
      try (ResultSet result = stmt.executeQuery()) {
        if (result.next()) {
          return new Teacher(
              result.getString("name"),
              result.getInt("id"),
              result.getString("email"),
              result.getString("password"));
        }
        connection.close();
      }
    }

    catch (SQLException e) {
      System.err.println("Error validating Teacher");
    }
    return null;
  }

  @Override
  public void insertTeacher(Teacher teacher) {
    String query = "INSERT INTO teachers (name, id, email, password) values (?,?,?,?)";
    try (Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {

      stmt.setString(1, teacher.getName());
      stmt.setInt(2, teacher.getID());
      stmt.setString(3, teacher.getEmail());
      stmt.setString(4, teacher.getPassword());
      stmt.executeUpdate();
      connection.close();
    } catch (SQLException e) {
      System.err.println("Error inserting teacher to database.");
    }
  }

  @Override
  public void updateTeacher(Teacher teacher) {
    String query = "UPDATE teachers set name = ?, id = ?, email = ?, pasword = ?";
    try (Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, teacher.getName());
      stmt.setInt(2, teacher.getID());
      stmt.setString(3, teacher.getEmail());
      stmt.setString(4, teacher.getPassword());
      stmt.executeUpdate();
      connection.close();

    } catch (SQLException e) {
      System.err.println("Error updating teacher info in database.");
    }
  }

  @Override
  public void deleteTeacher(Teacher teacher) {
    String query = "DELETE FROM teachers where id = ?";
    try (Connection connection = Database.getConnection();

        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setInt(1, teacher.getID());
      stmt.executeUpdate();
      connection.close();
    } catch (SQLException e) {
      System.err.println("Error deleting teacher from database.");
    }
  }
}
