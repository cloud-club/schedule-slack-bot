package cloudclub.schedule.slackbot.dto;

import cloudclub.schedule.slackbot.entity.Schedule;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ScheduleDto {
    private LocalDate scheduleDate;
    private String title;
    private String content;

    public ScheduleDto(LocalDate scheduleDate, String title, String content) {
        this.scheduleDate = scheduleDate;
        this.title = title;
        this.content = content;
    }

    @Builder
    public ScheduleDto(Schedule schedule) {
        this.scheduleDate = schedule.getSchedule_date();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
    }
}