package service;

import dao.ClassDAO;
import model.Class;
import java.util.List;

public class ClassService {
    private ClassDAO classDAO;

  public ClassService(ClassDAO classDAO) {
    this.classDAO = classDAO;
  }

  public List<Class> listAll() {
    return classDAO.listAllClass();
  }

  public Class findByID(int id) {
    return classDAO.findByID(id);
  }

  public void addClass(Class classroom) {
    classDAO.insertClass(classroom);
  }

  public void updateClass(Class classroom) {
    classDAO.updateClass(classroom);
  }

  public void deleteClass(int id) {
    classDAO.deleteClass(id);
  }
}
