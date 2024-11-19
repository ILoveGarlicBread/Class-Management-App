package model;

public final class Teacher extends Person {
  private int age; // constant age

  public Teacher() {
    this.age = 0;
  };

  public Teacher(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public Teacher(String name, int ID) {
    this.name = name;
    this.ID = ID;
    this.age = 0;
  }

  public Teacher(String name, int ID, String email, String password, int age) {
    this.name = name;
    this.ID = ID;
    this.email = email;
    this.password = password;
    this.age = age;
  }

  public final void viewInfo() {
    super.viewInfo();
    System.out.println("Age of teacher: " + age);

  }

  public final void updateInfo(String name, String email, String password, int ID) {
    super.updateInfo(name, email, password, ID);
  }

  public String getPassword() {
    return password;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
