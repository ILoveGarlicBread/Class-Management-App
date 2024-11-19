package dao;

import model.Class;
import java.util.List;

public interface ClassDAO {
  boolean insertClass(Class classroom);

  boolean updateClass(Class classroom);

  boolean deleteClass(int id);

  Class findByID(int id);

  List<Class> listAllClass();

}
