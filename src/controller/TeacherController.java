package controller;

import service.TeacherService;

import javax.swing.JComboBox;
import java.util.List;

import model.Teacher;

public class TeacherController {
  private TeacherService teacherService;

  public TeacherController() {
    teacherService = new TeacherService();
  }

  public void loadTeacherComboBox(JComboBox<String> teacherComboBox) {
    teacherComboBox.removeAllItems();
    List<Teacher> teachers = teacherService.ListAll();
    for (Teacher teacher : teachers) {
      teacherComboBox.addItem(teacher.getName());
    }
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
