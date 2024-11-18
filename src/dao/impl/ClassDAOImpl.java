package dao.impl;

import dao.ClassDAO;
import database.Database;
import model.Class;
import model.Teacher;
import model.Student;
import model.Subject;
import java.util.List;
import java.util.ArrayList;

import java.sql.*;

public class ClassDAOImpl implements ClassDAO {
  @Override
  public void insertClass(Class classroom) {
    String query = "INSERT INTO classes(id,name,subject_id,teacher_id)values(?,?,?,?)";
    try (Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setInt(1, classroom.getID());
      stmt.setString(2, classroom.getName());
      stmt.setString(3, classroom.getSubject());
      stmt.setInt(4, classroom.getTeacher());
      stmt.executeUpdate();

      stmt.close();
      connection.close();
    } catch (SQLException e) {
      System.out.println("Error insert classroom");
    }
  }

  @Override
  public void updateClass(Class classroom) {
    String query = "Update classes set id = ?, name=?,subject_id=?,teacher=? where id =?";
    try (Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setInt(1, classroom.getID());
      stmt.setString(2, classroom.getName());
      stmt.setString(3, classroom.getSubject());
      stmt.setInt(4, classroom.getTeacher());
      stmt.setInt(5, classroom.getID());
      stmt.executeUpdate();

      stmt.close();
      connection.close();
    } catch (SQLException e) {
      System.out.println("Error update classroom");
    }
  }

  @Override
  public void deleteClass(int ID) {
    String query = "Delete from classes where id = ?";
    try (Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setInt(1, ID);
      stmt.executeUpdate();

      stmt.close();
      connection.close();
    } catch (SQLException e) {
      System.out.println("Error deleting classroom");
    }
  }

  private List<Student> getStudentsForClass(int ID, Connection connection) {
    List<Student> students = new ArrayList<>();
    String query = "Select s.name, s.id, s.email" +
        "From class_student cs"
        + "Join students s on cs.student_id = s.id"
        + "where cs.class_id = ?";
    try (
        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setInt(1, ID);
      ResultSet result = stmt.executeQuery();
      while (result.next()) {
        String student_name = result.getString("s.name");
        int student_id = result.getInt("s.id");
        String student_email = result.getString("s.email");
        Student student = new Student(student_name, student_id, student_email);
        students.add(student);
      }
      stmt.close();
      connection.close();

    } catch (SQLException e) {
      System.out.println("Error retrieving student for Class");
    }
    return students;

  }

  @Override
  public Class findByID(int ID) {
    String query = "Select c.id, c.name, s.name,s.id, t.name, t.id"
        + "From classes c"
        + "Join subjects s  on c.subject_id = s.id"
        + "Join teachers t on c.teacher_id = t.id"
        + "Where class ID = ?";
    try (

        Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query);) {
      stmt.setInt(1, ID);
      ResultSet result = stmt.executeQuery();

      if (result.next()) {
        Subject subject = new Subject(result.getString("s.id"), result.getString("s.name"));
        Teacher teacher = new Teacher(result.getString("t.name"), result.getInt("t.id"), result.getInt("t.age"));
        List<Student> students = getStudentsForClass(ID, connection);
        return new Class(result.getString("c.name"),
            result.getInt("c.id"),
            subject, teacher, students);
      }
      stmt.close();
      connection.close();
    } catch (SQLException e) {
      System.out.println("Error retrieving class");
    }
    return null;

  }

  @Override
  public List<Class> listAllClass() {
    List<Class> classes = new ArrayList<>();
    String query = " Select c.name, c.id, t.name, s.name"
        + " from classes"
        + "join teachers t on c.teacher_id = t.id"
        + "join subjects s on c.subject_id = s.id"
        + "order by s.name ASC";
    try (Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {
      ResultSet result = stmt.executeQuery();
      while (result.next()) {
        Subject subject = new Subject(result.getString("s.id"), result.getString("s.name"));
        Teacher teacher = new Teacher(result.getString("t.name"), result.getInt("t.id"), result.getInt("t.age"));
        classes.add(new Class(
            result.getString("name"),
            result.getInt("id"),
            subject, teacher));
      }
      stmt.close(); 
      connection.close();
    } catch (SQLException e) {
      System.out.println("Error retrieving all classes");
    }
    return classes;
  }
}
