package model;

public class Subject {
  private String subjectID;
  private String subjectName;

  public Subject() {
  };

  public Subject(String ID, String name) {
    this.subjectID = ID;
    this.subjectName = name;
  }

  public String getName() {
    return subjectName;
  }

  public String getID() {
    return subjectID;
  }

  public void setName(String name) {
    this.subjectName = name;
  }

  public void setID(String ID) {
    this.subjectID = ID;
  }

  @Override
  public String toString() {
    return this.subjectName;
  }

}
