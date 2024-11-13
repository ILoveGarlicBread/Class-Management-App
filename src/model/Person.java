package model;

public class Person {
  protected String name;
  protected String email;
  protected String password;
  protected int ID;

  Person() {
  };

  Person(String name, String email, String password, int ID) {
    this.name = name;
    this.name = email;
    this.password = password;
    this.ID = ID;
  };

  public void setName(String name) {
    this.name = name;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public int getID() {
    return ID;
  }

  public String getEmail() {
    return email;
  }
}
