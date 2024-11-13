package model;

public class Teacher extends Person {

  public Teacher() {
  };

  public Teacher(String name, int ID) {
    this.name = name;
    this.ID = ID;
  }

  public Teacher(String name, int ID, String email, String password) {
    this.name = name;
    this.ID = ID;
    this.email = email;
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

}
