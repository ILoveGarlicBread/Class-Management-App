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

  public boolean addStudent(Student student) {
    return studentDAO.insertStudent(student);
  }

  public boolean updateStudent(Student student) {
    return studentDAO.updateStudent(student);
  }

  public boolean deleteStudent(Student student) {
    return studentDAO.deleteStudent(student);
  }

}
