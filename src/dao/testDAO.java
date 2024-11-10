package dao;

import studentmanagement.Student;
import java.util.List;

public interface testDAO {
  List<Student> getAllStudent();

  Student getStudentbyid();

  void saveStudent();

  void deleteStudent();
}
