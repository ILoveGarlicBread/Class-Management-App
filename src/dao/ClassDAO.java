package dao;

import model.Class;
import java.util.List;

public interface ClassDAO {
  void insertClass(Class classroom);

  void updateClass(Class classroom);

  void deleteClass(int id);

  Class findByID(int id);

  List<Class> listAllClass();

}
