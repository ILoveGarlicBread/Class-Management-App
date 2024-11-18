package controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import service.StudentService;
import model.Student;

public class StudentController {
  private StudentService studentService;

  public StudentController() {
    studentService = new StudentService();
  }

  public void loadStudentTable(JTable table) {
    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
    tableModel.setRowCount(0);
    List<Student> students = studentService.listAll();
    for (Student student : students) {
      tableModel.addRow(new Object[] { student.getName(), student.getID(), student.getEmail() });
    }
  }

  public void insertStudentTable() {
  }

  public void deleteStudentTable() {

  }

}
