package model;

public class Teacher extends Person {

  public Teacher() {
  };

  public Teacher(String name, String ID, String email, String password) {
    this.name = name;
    this.ID = ID;
    this.email = email;
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

}
