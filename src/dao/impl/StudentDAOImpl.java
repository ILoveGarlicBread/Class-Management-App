package dao.impl;

import java.sql.*;
import dao.StudentDAO;
import model.Student;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

public class StudentDAOImpl implements StudentDAO {
  private Connection connection;

  public StudentDAOImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<Student> listAllStudents() {
    List<Student> students = new ArrayList<>();
    String query = "SELECT * FROM students";
    try (PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet result = stmt.executeQuery()) {
      while (result.next()) {
        students.add(new Student(
            result.getString("name"),
            result.getString("id"),
            result.getString("email")));
      }

    } catch (

    SQLException e) {
      System.out.println("Error retrieving all students.");
    }
    return students;

  }

  @Override
  public Student findByID(String id) {
    String query = "SELECT * FROM students WHERE id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, id);
      try (ResultSet result = stmt.executeQuery()) {
        if (result.next()) {
          return new Student(
              result.getString("name"),
              result.getString("id"),
              result.getString("email"));
        }
      }
    } catch (SQLException e) {
      System.err.println("Error retrieving student from the database.");
    }
    return null;
  }

  @Override
  public void insertStudent(Student student) {
    String query = "INSERT INTO students (name, id, email) values(?,?,?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, student.getName());
      stmt.setString(2, student.getID());
      stmt.setString(3, student.getEmail());
      stmt.executeUpdate();
    } catch (SQLException e) {
      System.err.println("Error inserting student to database.");
    }
  }

  @Override
  public void updateStudent(Student student) {
    String query = "UPDATE students SET name = ?, id = ?, email = ? WHERE id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, student.getName());
      stmt.setString(2, student.getID());
      stmt.setString(3, student.getEmail());
      stmt.setString(4, student.getID());
      stmt.executeUpdate();
    } catch (SQLException e) {
      System.err.println("Errer updating student in database.");
    }
  }

  @Override
  public void deleteStudent(Student student) {
    String query = "DELETE FROM students where id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, student.getID());
      stmt.executeUpdate();
    } catch (SQLException e) {
      System.err.println("Error deleting student from database.");
    }
  }
}
