package service;

import dao.StudentDAO;
import model.Student;
import dao.impl.StudentDAOImpl;
import java.util.List;

public class StudentService {
  private StudentDAO studentDAO;

  public StudentService() {
    studentDAO = new StudentDAOImpl();
  }

  public List<Student> listAll() {
    return studentDAO.listAllStudents();
  }

  public Student findStudentByID(String id) {
    return studentDAO.findByID(id);
  }

  public void addStudent(Student student) {
    studentDAO.insertStudent(student);
  }

  public void updateStudent(Student student) {
    studentDAO.updateStudent(student);
  }

  public void deleteStudent(Student student) {
    studentDAO.deleteStudent(student);
  }

}
