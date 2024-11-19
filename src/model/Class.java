package model;

import java.util.List;

public class Class {
  private int classID;
  private String className;
  private Teacher teacher;
  private Subject subject;
  private List<Student> students;

  public Class() {
  }

  public Class(String name, Subject subject, Teacher teacher) {
    this.className = name;
    this.subject = subject;
    this.teacher = teacher;
  }

  public Class(String name, int ID, Subject subject, Teacher teacher) {
    this.className = name;
    this.classID = ID;
    this.subject = subject;
    this.teacher = teacher;
  }

  public Class(String name, int ID, Subject subject, Teacher teacher, List<Student> students) {
    this.className = name;
    this.classID = ID;
    this.subject = subject;
    this.teacher = teacher;
    this.students = students;
  }

  public String getName() {
    return className;
  }

  public int getID() {
    return classID;
  }

  public Subject getSubject() {
    return subject;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setName(String name) {
    this.className = name;
  }

  public void setID(int ID) {
    this.classID = ID;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }
}
