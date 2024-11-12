package controller;

import service.TeacherService;
import model.Teacher;

public class TeacherController {
  private TeacherService teacherService;

  public TeacherController() {
    teacherService = new TeacherService();
  }

  public boolean authenticateUser(String email, String password) {
    Teacher teacher = teacherService.authenticateTeacher(email, password);
    if (teacher != null) {
      return true;
    } else {
      return false;
    }
  }
}
