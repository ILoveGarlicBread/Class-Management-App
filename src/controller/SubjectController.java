package controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import service.SubjectService;
import model.Subject;

public class SubjectController {

  private SubjectService subjectService;

  public SubjectController() {
    subjectService = new SubjectService();
  }

  public void loadSubjectComboBox(JComboBox<String> subjectComboBox) {
    subjectComboBox.removeAllItems();
    List<Subject> subjects = subjectService.listAll();
    for (Subject subject : subjects) {
      subjectComboBox.addItem(subject.getName());
    }
  }

}
