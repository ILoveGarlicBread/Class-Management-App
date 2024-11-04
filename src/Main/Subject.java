package Main;

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
    // Add subject in database
  }

  public void deleteSubject(int ID) {
    // Delete subject in database
  }
}
