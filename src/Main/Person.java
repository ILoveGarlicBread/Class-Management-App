package Main;

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

  public void viewInfo() {
    // GUI integration
    System.out.println(name);
    System.out.println(ID);
    System.out.println(email);
  }

  public void updateInfo(String name, String ID, String email) {
    this.name = name;
    this.email = email;
    this.ID = ID;
  }

}
