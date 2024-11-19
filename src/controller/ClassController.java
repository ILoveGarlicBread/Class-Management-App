
package controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import service.ClassService;
import model.Class;
import model.Student;

public class ClassController {

  private ClassService classService;

  public ClassController() {
    classService = new ClassService();
  }

  public void loadClassesTable(JTable table) {
    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
    tableModel.setRowCount(0);
    List<Class> classes = classService.listAll();
    for (Class aClass : classes) {
      tableModel.addRow(new Object[] { aClass.getName(), aClass.getID(), aClass.getSubject(), aClass.getTeacher() });
    }
  }

  public void loadStudentInClassTable(JTable table, int id) {
    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
    tableModel.setRowCount(0);
    List<Student> students = classService.listStudentsInClass(id);
    for (Student student : students) {
      tableModel.addRow(new Object[] { student.getName(), student.getID(), student.getEmail() });
    }
  }

  public boolean insertStudentInClassTable(int classID, int studentID) {
    return classService.insertStudentInClass(classID, studentID);
  }

  public boolean insertClassTable(String className, String subjectName, String teacherName) {
    return classService.addClass(className, subjectName, teacherName);
  }

  public boolean updateClassTable(String className, int id, String subjectName, String teacherName) {
    return classService.updateClass(className, id, subjectName, teacherName);
  }

  public boolean deleteClassTable(int id) {
    return classService.deleteClass(id);
  }
}
