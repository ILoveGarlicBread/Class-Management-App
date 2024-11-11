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

}
