package dao.impl;

import dao.ScoreDAO;
import database.Database;
import model.Class;
import model.Score;
import model.Teacher;
import model.Student;
import model.Subject;
import java.util.List;
import java.util.ArrayList;

import java.sql.*;
public class ScoreDAOImpl implements ScoreDAO {
    @Override
    public void addScore(Score score_report) {
      String query = "INSERT INTO score_reports(report_id,student_id,subject_id,score)values(?,?,?,?)";
      try (Connection connection = Database.getConnection();
          PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, score_report.getReportID());
        stmt.setInt(2, score_report.getstudent());
        stmt.setString(3, score_report.getsubject());
        stmt.setDouble(4, score_report.getScore());
        stmt.executeUpdate();

        stmt.close();
        connection.close();
      } catch (SQLException e) {
        System.out.println("Error insert classroom");
      }
    }
    @Override
  public void updateScore(Score score_report) {
    String query = "Update score_reports set report_id = ?, student_id=?,subject_id=?,score= ? where student_id =?";
    try (Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setInt(1, score_report.getReportID());
      stmt.setInt(2, score_report.getstudent());
      stmt.setString(3, score_report.getsubject());
      stmt.setDouble(4, score_report.getScore());
      stmt.executeUpdate();

      stmt.close();
      connection.close();
    } catch (SQLException e) {
      System.out.println("Error update classroom");
    }
  }
  @Override
  public List<Score> listAllScore() {
    List<Score> scoreReports = new ArrayList<>();
    String query = "SELECT report_id, student_id, subject_id, score FROM score_reports ORDER BY student_id ASC";

    try (Connection connection = Database.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
        
        ResultSet result = stmt.executeQuery();
        while (result.next()) {
            // Create a new ScoreReport object for each row in the ResultSet
            Student student = new Student(result.getString("name"), result.getInt("id"), result.getString("email"));
            Subject subject = new Subject(result.getString("id"),result.getString("name"));

            Score scoreReport = new Score(
                result.getInt("report_id"),
                student,
                subject,
                result.getDouble("score")
            );
            scoreReports.add(scoreReport); // Add the ScoreReport object to the list
        }

        stmt.close();
        connection.close();
    } catch (SQLException e) {
        System.out.println("Error retrieving all score reports");
        e.printStackTrace();
    }
    return scoreReports;
  }
  @Override
  public void deleteScore(int id) {
    String query = "Delete from score_reports where report_id = ?";
    try (Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setInt(1, id);
      stmt.executeUpdate();

      stmt.close();
      connection.close();
    } catch (SQLException e) {
      System.out.println("Error deleting classroom");
    }
  }
}
