package studentmanagement;

public class Subject {
  private int subjectID;
  private String subjectName;

  public Subject() {
  };

  public Subject(int ID, String name) {
    this.subjectID = ID;
    this.subjectName = name;
  }

  public void addSubject(int ID, String name) {
  }

  public void deleteSubject(int ID) {
    // Delete subject in database
  }
}
