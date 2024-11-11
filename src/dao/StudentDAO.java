package dao;

import model.Student;
import java.util.List;

public interface StudentDAO {
  List<Student> listAllStudents();

  Student findByID(String id);

  void insertStudent(Student student);

  void updateStudent(Student student);

  void deleteStudent(Student student);
}
