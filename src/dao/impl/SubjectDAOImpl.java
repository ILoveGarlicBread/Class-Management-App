package dao.impl;

import dao.ClassDAO;
import dao.SubjectDAO;
import database.Database;
import model.Class;
import model.Teacher;
import model.Student;
import model.Subject;
import java.util.List;
import java.util.ArrayList;

import java.sql.*;

public class SubjectDAOImpl implements SubjectDAO {
  @Override
  public void addSubject(Subject subject) {
    String query = "INSERT INTO subjects(id,name)values(?,?)";
    try (Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, subject.getID());
      stmt.setString(2, subject.getName());
      stmt.executeUpdate();
      
      stmt.close();
      connection.close();
    } catch (SQLException e) {
      System.out.println("Error insert subject");
    }
  }
  @Override
  public void updateSubject(Subject subject) {
    String query = "Update classes set id = ?, name=? where id=?";
    try (Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, subject.getID());
      stmt.setString(2, subject.getName());
      stmt.setString(3, subject.getID());

      stmt.executeUpdate();
      stmt.close();
      connection.close();
    } catch (SQLException e) {
      System.out.println("Error update subject");
    }
  }
  @Override
  public void deleteSubject(String id) {
    String query = "Delete from classes where id = ?";
    try (Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, id);
      stmt.executeUpdate();

      stmt.close();
      connection.close();
    } catch (SQLException e) {
      System.out.println("Error deleting subject");
    }
  }
  @Override
  public List<Subject> listAllSubjects() {
    List<Subject> subjects = new ArrayList<>();
    String query = " Select id, name"
        + " from subjects"
        + "order by name ASC"; 
    try (Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {
      ResultSet result = stmt.executeQuery();
      while (result.next()) {
        subjects.add(new Subject(
            result.getString("id"),
            result.getString("name")));
      }
      stmt.close();
      connection.close();
    } catch (SQLException e) {
      System.out.println("Error retrieving all classes");
    }
    return subjects;
  }
  @Override
  public Subject findByID(String id) {
    String query = "SELECT * FROM subjects WHERE id = ?";
    try (Connection connection = Database.getConnection();

        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, id);
      try (ResultSet result = stmt.executeQuery()) {
        if (result.next()) {
          return new Subject(
              result.getString("id"),
              result.getString("name"));
        }
        stmt.close();
        connection.close();
      }
    } catch (SQLException e) {
      System.err.println("Error retrieving student from the database.");
    }
    return null;
  }
}
