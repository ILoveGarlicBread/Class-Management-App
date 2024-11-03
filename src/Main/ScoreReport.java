package Main;

public class ScoreReport extends Student {
  private double score;

  ScoreReport() {
  };

  ScoreReport(Student Student, double score) {
    this.score = score;
  }

  public void updateScore(String StudentID, double score) {
    this.score = score;
  }
}
