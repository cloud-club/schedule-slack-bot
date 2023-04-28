package cloudclub.schedule.slackbot.repository;

import cloudclub.schedule.slackbot.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleJpaRepository extends JpaRepository<Schedule, Long> {

  @Query(value = """
    select *
    from schedule s
    where s.remind_date = :remindDate
  """, nativeQuery=true)
  List<Schedule> findSchedules(@Param("remindDate") LocalDate remindDate);
}
