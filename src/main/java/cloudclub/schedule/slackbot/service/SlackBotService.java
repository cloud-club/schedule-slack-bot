package cloudclub.schedule.slackbot.service;

import cloudclub.schedule.slackbot.dto.ScheduleDto;
import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.model.block.composition.TextObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.slack.api.model.block.Blocks.*;
import static com.slack.api.model.block.Blocks.section;
import static com.slack.api.model.block.composition.BlockCompositions.markdownText;
import static com.slack.api.model.block.composition.BlockCompositions.plainText;

@Service
@RequiredArgsConstructor
@Slf4j
public class SlackBotService {

    //token info
    @Value(value = "${slack.token}")
    private String token;

    //channel info
    @Value(value = "${slack.channel.monitor}")
    private String channel;

    public void postMessage(ScheduleDto scheduleDto) throws IOException {

        // Slack 메세지 보내기
        try{
            List<TextObject> textObjects = new ArrayList<>();
            textObjects.add(markdownText("*일정 제목:*\n" + scheduleDto.getName()));
            textObjects.add(markdownText("*일정 내용:*\n" + scheduleDto.getTitle()));
            textObjects.add(markdownText("*일정 일자:*\n" + scheduleDto.getContent()));

            MethodsClient methods = Slack.getInstance().methods(token);
            ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                    .channel(channel)
                    .blocks(asBlocks(
                            header(header -> header.text(plainText( scheduleDto.getName() + "님이 일정을 추가하셨습니다!"))),
                            divider(),
                            section(section -> section.fields(textObjects)
                            ))).build();

            methods.chatPostMessage(request);
        } catch (SlackApiException | IOException e) {
            log.error(e.getMessage());
            throw new IllegalAccessError();
        }
    }
}
