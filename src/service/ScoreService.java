package service;

import java.util.List;

import dao.ScoreDAO;
import dao.impl.ScoreDAOImpl;
import model.Score;

public class ScoreService {
    private ScoreDAO scoreDAO;

  public ScoreService() {
    scoreDAO = new ScoreDAOImpl() {
    
    };
  }
  public List<Score> listAll() {
    return scoreDAO.listAllScore();
  }
  public void addScore(Score score) {
    scoreDAO.addScore(score);
  }

  public void updateScore(Score score) {
    scoreDAO.updateScore(score);
  }

  public void deleteScore(int score) {
    scoreDAO.deleteScore(score);
  }

}
