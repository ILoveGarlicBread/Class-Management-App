package dao;

import java.util.Optional;
import java.util.List;
import model.Subject;

public interface SubjectDAO {
  List<Subject> listAllSubjects();

  Subject findByID(String id);

  void addSubject(Subject subject);

  void updateSubject(Subject subject);

  Optional<Subject> findByName(String Name);

  void deleteSubject(String id);
}
