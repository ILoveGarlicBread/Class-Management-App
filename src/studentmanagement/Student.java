package studentmanagement;

public class Student extends Person {
  protected String studentID;

  public Student() {
  }

  public Student(String name, String ID, String email, String password) {
    this.name = name;
    this.studentID = ID;
    this.email = email;
    this.password = password;
  }

  public void viewInfo() {
    // GUI integration
    System.out.println(name);
    System.out.println(studentID);
    System.out.println(email);
  }

  public void updateInfo(String name, String ID, String email) {
    this.name = name;
    this.email = email;
    this.studentID = ID;
  }

  public void addStudentDB(String name, String ID, String email) {
    // Database integration
  }

  public void deleteStudentDB(String name, String ID) {
    // Database integration
  }

}
