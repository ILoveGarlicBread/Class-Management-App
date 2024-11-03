package Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Attendance extends Subject {
  private LocalDate Date;

  public void checkAttendance(LocalDate Date, int ID) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate now = LocalDate.now();
    dtf.format(Date);
    if (Date != now) {
      // Error
    }
  }

}
