package model;

public class Student extends Person {
  private static int studentCount = 0; // Static variable to track number of students

  public Student() {
    studentCount++; // Increment the count whenever a new Student object is created
  }

  public Student(int ID) {
    this.ID = ID;
  }

  public Student(String name, String email) {
    this.name = name;
    this.email = email;
    studentCount++;
  }

  public Student(String name, int ID, String email) {
    this.name = name;
    this.ID = ID;
    this.email = email;
    studentCount++;
  }

  public final void viewInfo() {
    super.viewInfo();
  }

  public final void updateInfo(String name, String email, String password, int ID) {
    super.updateInfo(name, email, password, ID);
  }

  // Static method to access the studentCount
  public static int getStudentCount() {
    return studentCount;
  }
}
