package dao;

import java.util.List;
import model.Score;

public interface ScoreDAO {
  List<Score> listAllScore();

  Score findByID(String id);

  void addScore(Score score);

  void updateScore(Score score);

  void deleteScore(String id);
}
