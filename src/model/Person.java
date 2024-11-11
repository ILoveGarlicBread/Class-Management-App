package model;

public class Person {
  protected String name;
  protected String email;
  protected String password;
  protected String ID;

  Person() {
  };

  Person(String name, String email, String password, String ID) {
    this.name = name;
    this.name = email;
    this.password = password;
    this.ID = ID;
  };

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
