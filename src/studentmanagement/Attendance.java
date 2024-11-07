package studentmanagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Attendance {
  private LocalDate Date;

  public void checkAttendance(LocalDate Date, Student Student1) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate now = LocalDate.now();
    dtf.format(Date);
    if (Date != now) {
      // Error
    }
  }

}
