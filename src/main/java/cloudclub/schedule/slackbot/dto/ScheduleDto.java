package cloudclub.schedule.slackbot.dto;

import lombok.Data;

@Data
public class ScheduleDto {
    private String name;
    private String title;
    private String content;
}