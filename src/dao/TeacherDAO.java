package dao;

import model.Teacher;

public interface TeacherDAO {

  void insertTeacher(Teacher teacher);

  void updateTeacher(Teacher teacher);

  void deleteTeacher(Teacher teacher);
}
