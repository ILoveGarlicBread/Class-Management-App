package dao;

import model.Class;
import model.Student;
import java.util.List;

public interface ClassDAO {
  boolean insertClass(Class classroom);

  boolean updateClass(Class classroom);

  boolean deleteClass(int id);

  boolean insertStudentInClass(int classID, int studentID);

  Class findByID(int id);

  List<Class> listAllClass();

  List<Student> listStudentsInClass(int id);

}
