package service;

import dao.TeacherDAO;
import dao.impl.TeacherDAOImpl;
import model.Teacher;

public class TeacherService {
  private TeacherDAO teacherDAO;

  public TeacherService() {
    teacherDAO = new TeacherDAOImpl() {

    };
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

  public Teacher authenticateTeacher(String email, String password) {
    return teacherDAO.authenticateTeacher(email, password);
  }
}
