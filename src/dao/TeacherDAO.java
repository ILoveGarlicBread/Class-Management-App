package dao;

import java.util.Optional;
import model.Teacher;
import java.util.List;

public interface TeacherDAO {

  void insertTeacher(Teacher teacher);

  void updateTeacher(Teacher teacher);

  void deleteTeacher(Teacher teacher);

  List<Teacher> listAllTeachers();

  Optional<Teacher> findByName(String Name);

  Teacher authenticateTeacher(String email, String password);
}
