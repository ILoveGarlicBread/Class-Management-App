
package controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import service.ClassService;
import model.Class;

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

  public boolean insertClassTable(String className, String subjectName, String teacherName) {
    return classService.addClass(className, subjectName, teacherName);
  }

  public boolean updateClassTable(String className, int id, String subjectName, String teacherName) {
    return classService.updateClass(className, id, subjectName, teacherName);
  }
}
