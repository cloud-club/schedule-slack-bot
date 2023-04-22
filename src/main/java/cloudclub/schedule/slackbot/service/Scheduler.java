package cloudclub.schedule.slackbot.service;

import cloudclub.schedule.slackbot.dto.ScheduleDto;
import cloudclub.schedule.slackbot.entity.Schedule;
import cloudclub.schedule.slackbot.repository.ScheduleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Scheduler {

  private final ScheduleJpaRepository scheduleJpaRepository;
  private final SlackBotService slackBotService;

  @Scheduled(cron = "* * 9 * * *")
  public void findSchedules() {
    List<Schedule> schedules = scheduleJpaRepository.findSchedules(LocalDate.now());

    schedules.forEach(i -> {
      try {
        slackBotService.postMessage(ScheduleDto.builder().schedule(i).build());
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }
}
