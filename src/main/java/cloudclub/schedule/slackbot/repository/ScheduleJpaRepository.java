package cloudclub.schedule.slackbot.repository;

import cloudclub.schedule.slackbot.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleJpaRepository extends JpaRepository<Schedule, Long> {
}
