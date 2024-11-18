package dao.impl;

import java.sql.*;
import database.Database;
import dao.StudentDAO;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

  @Override
  public List<Student> listAllStudents() {
    List<Student> students = new ArrayList<>();
    String query = "SELECT name, id, email FROM students order by name";
    try (Connection connection = Database.getConnection();

        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet result = stmt.executeQuery()) {
      while (result.next()) {
        students.add(new Student(
            result.getString("name"),
            result.getInt("id"),
            result.getString("email")));
      }
      connection.close();

    } catch (

    SQLException e) {
      System.out.println("Error retrieving all students.");
    }
    return students;

  }

  @Override
  public Student findByID(String id) {
    String query = "SELECT * FROM students WHERE id = ?";
    try (Connection connection = Database.getConnection();

        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, id);
      try (ResultSet result = stmt.executeQuery()) {
        if (result.next()) {
          return new Student(
              result.getString("name"),
              result.getInt("id"),
              result.getString("email"));
        }
        connection.close();
      }
    } catch (SQLException e) {
      System.err.println("Error retrieving student from the database.");
    }
    return null;
  }

  @Override
  public boolean insertStudent(Student student) {
    String query = "INSERT INTO students (name, email) values(?,?)";
    try (Connection connection = Database.getConnection();

        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, student.getName());
      stmt.setString(2, student.getEmail());
      stmt.executeUpdate();
      connection.close();
    } catch (SQLException e) {
      System.err.println("Error inserting student to database." + e.getMessage());
      return false;
    }
    return true;
  }

  @Override
  public boolean updateStudent(Student student) {
    String query = "UPDATE students SET name = ?, email = ? WHERE id = ?";
    try (Connection connection = Database.getConnection();

        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, student.getName());
      stmt.setString(2, student.getEmail());
      stmt.setInt(3, student.getID());
      stmt.executeUpdate();
      connection.close();
    } catch (SQLException e) {
      System.err.println("Error updating student in database." + e.getMessage());
      return false;
    }
    return true;
  }

  @Override
  public boolean deleteStudent(Student student) {
    String query = "DELETE FROM students where id = ?";
    try (Connection connection = Database.getConnection();

        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setInt(1, student.getID());
      stmt.executeUpdate();
      connection.close();
    } catch (SQLException e) {
      System.err.println("Error deleting student from database." + e.getMessage());
      return false;
    }
    return true;
  }
}
