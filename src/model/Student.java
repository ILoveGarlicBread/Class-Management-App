package model;

public class Student extends Person {
  protected String studentID;

  public Student() {
  }

  public Student(String name, String ID, String email) {
    this.name = name;
    this.studentID = ID;
    this.email = email;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public String getID() {
    return ID;
  }

  public String getEmail() {
    return email;
  }

}
