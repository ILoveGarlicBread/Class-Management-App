package model;

public class Teacher extends Person {
  private final int age;
  public Teacher() {
    this.age= 0;
  };

  public Teacher(String name, int ID, int age) {
    this.name = name;
    this.ID = ID;
    this.age= age;
  }

  public Teacher(String name, int ID, String email, String password, int age) {
    this.name = name;
    this.ID = ID;
    this.email = email;
    this.password = password;
    this.age= age;
  }
  public final void viewInfo(){
    super.viewInfo();
    System.out.println("Age of teacher: "+ age);

  }
  public final void updateInfo(String name, String email, String password, int ID){
    super.updateInfo(name, email, password, ID);
  }
  public String getPassword() {
    return password;
  }
  public int getAge() {
    return age;
  }
}
