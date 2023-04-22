package cloudclub.schedule.slackbot.web;

import cloudclub.schedule.slackbot.dto.ScheduleDto;
import cloudclub.schedule.slackbot.service.SlackBotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/slack")
public class SlackController {

    private final SlackBotService slackBotService;

    @PostMapping("/message")
    public void postInquiry (@RequestBody ScheduleDto scheduleDto) throws IOException {
        slackBotService.postMessage(scheduleDto);
    }
}