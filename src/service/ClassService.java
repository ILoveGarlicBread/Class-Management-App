package service;

import java.util.Optional;
import dao.ClassDAO;
import dao.SubjectDAO;
import dao.TeacherDAO;
import dao.impl.ClassDAOImpl;
import dao.impl.SubjectDAOImpl;
import dao.impl.TeacherDAOImpl;
import model.Class;
import model.Subject;
import model.Teacher;
import java.util.List;

public class ClassService {
  private ClassDAO classDAO;
  private SubjectDAO subjectDAO;
  private TeacherDAO teacherDAO;

  public ClassService() {
    classDAO = new ClassDAOImpl();
    subjectDAO = new SubjectDAOImpl();
    teacherDAO = new TeacherDAOImpl();

  }

  public List<Class> listAll() {
    return classDAO.listAllClass();
  }

  public Class findByID(int id) {
    return classDAO.findByID(id);
  }

  public boolean addClass(String className, String subjectName, String teacherName) {
    Optional<Teacher> teacher = teacherDAO.findByName(teacherName);
    Optional<Subject> subject = subjectDAO.findByName(subjectName);
    Class classroom = new Class(className, subject.get(), teacher.get());
    return classDAO.insertClass(classroom);
  }

  public boolean updateClass(String className, int id, String subjectName, String teacherName) {
    Optional<Teacher> teacher = teacherDAO.findByName(teacherName);
    Optional<Subject> subject = subjectDAO.findByName(subjectName);

    Class classroom = new Class(className, id, subject.get(), teacher.get());
    return classDAO.updateClass(classroom);
  }

  public boolean deleteClass(int id) {
    return classDAO.deleteClass(id);
  }
}
