package service;

import java.util.List;

import dao.SubjectDAO;
import dao.impl.SubjectDAOImpl;
import model.Subject;

public class SubjectService {
    private SubjectDAO subjectDAO;

  public SubjectService() {
    subjectDAO = new SubjectDAOImpl() {
    };
  }
  public List<Subject> listAll() {
    return subjectDAO.listAllSubjects();
  }
  public Subject findByID(String id) {
    return subjectDAO.findByID(id);
  }
  public void addSubject(Subject subject) {
    subjectDAO.addSubject(subject);
  }

  public void updateSubject(Subject subject) {
    subjectDAO.updateSubject(subject);
  }

  public void deleteSubject(String id) {
    subjectDAO.deleteSubject(id);
  }
  
}
