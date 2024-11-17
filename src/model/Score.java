package model;

public class Score {
  private Student student;
  private int reportID;
  private Subject subject;
  private double score;

  public Score() {
  };

  public Score(int reportID, Student student, Subject subject, double score) {
    this.reportID = reportID;
    this.student = student;
    this.score = score;
    this.subject = subject;
  }

  public Score(Student student, Subject subject, double score) {
    this.student = student;
    this.score = score;
    this.subject = subject;
  }

  public int getReportID() {
    return reportID;
  }

  public void setReportID(int reportID) {
    this.reportID = reportID;
  }

  public int getstudent() {
    return student.ID;
  }

  public double getScore() {
    return score;
  }

  public String getsubject() {
    return subject.getID();
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public void setSubjcet(Subject subject) {
    this.subject = subject;
  }

  public void setScore(double score) {
    this.score = score;
  }
}
