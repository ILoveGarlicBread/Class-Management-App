package dao;

import model.Student;
import java.util.List;

public interface StudentDAO {
  List<Student> listAllStudents();

  Student findByID(String id);

  boolean insertStudent(Student student);

  boolean updateStudent(Student student);

  boolean deleteStudent(Student student);
}
