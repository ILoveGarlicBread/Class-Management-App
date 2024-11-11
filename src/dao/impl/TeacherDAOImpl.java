package dao.impl;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.TeacherDAO;
import model.Teacher;

public class TeacherDAOImpl implements TeacherDAO {
  private Connection connection;

  public TeacherDAOImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void insertTeacher(Teacher teacher) {
    String query = "INSERT INTO teachers (name, id, email, password) values (?,?,?,?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, teacher.getName());
      stmt.setString(2, teacher.getID());
      stmt.setString(3, teacher.getEmail());
      stmt.setString(4, teacher.getPassword());
      stmt.executeUpdate();
    } catch (SQLException e) {
      System.err.println("Error inserting teacher to database.");
    }
  }

  @Override
  public void updateTeacher(Teacher teacher) {
    String query = "UPDATE teachers set name = ?, id = ?, email = ?, pasword = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, teacher.getName());
      stmt.setString(2, teacher.getID());
      stmt.setString(3, teacher.getEmail());
      stmt.setString(4, teacher.getPassword());
      stmt.executeUpdate();

    } catch (SQLException e) {
      System.err.println("Error updating teacher info in database.");
    }
  }

  @Override
  public void deleteTeacher(Teacher teacher) {
    String query = "DELETE FROM teachers where id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, teacher.getID());
    } catch (SQLException e) {
      System.err.println("Error deleting teacher from database.");
    }
  }
}
