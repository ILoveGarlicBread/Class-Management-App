package service;

import dao.TeacherDAO;
import model.Teacher;

public class TeacherService {
  private TeacherDAO teacherDAO;

  public TeacherService(TeacherDAO teacherDAO) {
    this.teacherDAO = teacherDAO;
  }

  public void addTeacher(Teacher teacher) {
    teacherDAO.insertTeacher(teacher);
  }

  public void updateTeacher(Teacher teacher) {
    teacherDAO.updateTeacher(teacher);
  }

  public void deleteTeacher(Teacher teacher) {
    teacherDAO.deleteTeacher(teacher);
  }

}
