package cloudclub.schedule.slackbot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Schedule {

  @Id
  @GeneratedValue
  @Column(name = "post_id", nullable = false)
  private Long id;

  @Column(name = "title", nullable = false, length = 100)
  private String title;

  @Column(name = "content", nullable = false, length = 500)
  private String content;

  @Column(name = "schedule_date", nullable = false)
  private LocalDate schedule_date;

  @Column(name = "remind_date", nullable = false)
  private LocalDate remind_date;

  @Column(name = "is_active", columnDefinition = "tinyint(1) default 1", nullable = false)
  private Boolean isActive = true;

  public void delete () {
    this.isActive = false;
  }

}