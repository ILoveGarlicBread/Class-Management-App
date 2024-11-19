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
  public boolean insertClass(Class classroom) {
    String query = "INSERT INTO classes (name,subject_id,teacher_id) values (?,?,?)";
    String findSubjectIdQuery = "SELECT id FROM subjects WHERE name = ?";
    String findTeacherIdQuery = "SELECT id FROM teachers WHERE name = ?";
    try (Connection connection = Database.getConnection()) {
      String subjectId;
      try (PreparedStatement findSubjectStmt = connection.prepareStatement(findSubjectIdQuery)) {
        findSubjectStmt.setString(1, classroom.getSubject().getName());
        try (ResultSet subjectResult = findSubjectStmt.executeQuery()) {
          if (subjectResult.next()) {
            subjectId = subjectResult.getString("id");
          } else {
            System.out.println("Error: Subject not found for name: " + classroom.getSubject());
            return false;
          }
        }
      }
      int teacherId;
      try (PreparedStatement findTeacherStmt = connection.prepareStatement(findTeacherIdQuery)) {
        findTeacherStmt.setString(1, classroom.getTeacher().getName());
        try (ResultSet teacherResult = findTeacherStmt.executeQuery()) {
          if (teacherResult.next()) {
            teacherId = teacherResult.getInt("id");
          } else {
            System.out.println("Error: Teacher not found for name: " + classroom.getTeacher());
            return false;
          }
        }
      }
      try (
          PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, classroom.getName());
        stmt.setString(2, subjectId);
        stmt.setInt(3, teacherId);
        stmt.executeUpdate();

        stmt.close();
        connection.close();
        return true;
      }
    } catch (SQLException e) {
      System.out.println("Error insert classroom: " + e.getMessage());
    }
    return false;
  }

  @Override
  public boolean updateClass(Class classroom) {
    String query = "Update classes set name=?,subject_id=?,teacher_id=? where id =?";
    try (Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, classroom.getName());
      stmt.setString(2, classroom.getSubject().getID());
      stmt.setInt(3, classroom.getTeacher().getID());
      stmt.setInt(4, classroom.getID());
      stmt.executeUpdate();

      stmt.close();
      connection.close();
      return true;
    } catch (SQLException e) {
      System.out.println("Error update classroom" + e.getMessage());
    }
    return false;
  }

  @Override
  public boolean deleteClass(int ID) {
    String query = "Delete from classes where id = ?";
    try (Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setInt(1, ID);
      stmt.executeUpdate();

      stmt.close();
      connection.close();
      return true;
    } catch (SQLException e) {
      System.out.println("Error deleting classroom");
    }
    return false;
  }

  private List<Student> getStudentsForClass(int ID, Connection connection) {
    List<Student> students = new ArrayList<>();
    String query = "Select s.name, s.id, s.email"
        + "From class_student cs"
        + "Join students s on cs.student_id = s.id"
        + "where cs.class_id = ?"
        + "order by s.name";
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
        Teacher teacher = new Teacher(result.getString("t.name"), result.getInt("t.id"));
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
    String query = " Select c.name as class_name, c.id as class_id, t.name as teacher_name, t.id as teacher_id, s.name as subject_name, s.id as subject_id "
        + "from classes c "
        + "join teachers t on c.teacher_id = t.id "
        + "join subjects s on c.subject_id = s.id "
        + "order by subject_name ";
    try (Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {
      ResultSet result = stmt.executeQuery();
      while (result.next()) {
        Subject subject = new Subject(result.getString("subject_id"), result.getString("subject_name"));
        Teacher teacher = new Teacher(result.getString("teacher_name"), result.getInt("teacher_id"));
        classes.add(new Class(
            result.getString("class_name"),
            result.getInt("class_id"),
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
