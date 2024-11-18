package model;

public final class Student extends Person {
  public Student() {
  }

  public Student(String name, int ID, String email) {
    this.name = name;
    this.ID = ID;
    this.email = email;
  }
  public final void viewInfo(){
      super.viewInfo();
  }
  public final void updateInfo(String name, String email, String password, int ID){
    super.updateInfo(name, email, password, ID);
  }
}

