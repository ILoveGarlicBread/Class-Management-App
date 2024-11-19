package dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import database.Database;
import dao.TeacherDAO;
import model.Teacher;

public class TeacherDAOImpl implements TeacherDAO {
  @Override
  public Optional<Teacher> findByName(String Name) {
    String query = "Select name, id from teachers where name = ?";
    try (Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query);) {
      stmt.setString(1, Name);
      ResultSet result = stmt.executeQuery();
      if (result.next()) {
        return Optional.of(new Teacher(result.getString("name"), result.getInt("id")));
      }
    } catch (SQLException e) {
      System.err.println("Error finding teacher by name.");
    }
    return Optional.empty();
  }

  @Override
  public List<Teacher> listAllTeachers() {
    List<Teacher> teachers = new ArrayList<>();
    String query = "Select name, id from teachers order by name";
    try (Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet result = stmt.executeQuery()) {
      while (result.next()) {
        teachers.add(new Teacher(
            result.getString("name"),
            result.getInt("id")));
      }
      connection.close();
    } catch (SQLException e) {
      System.err.println("Error getting all teachers.");
    }
    return teachers;
  }

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
              result.getString("email"),
              result.getString("password"));
        }
        stmt.close();
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

      stmt.close();
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

      stmt.close();
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

      stmt.close();
      connection.close();
    } catch (SQLException e) {
      System.err.println("Error deleting teacher from database.");
    }
  }
}
