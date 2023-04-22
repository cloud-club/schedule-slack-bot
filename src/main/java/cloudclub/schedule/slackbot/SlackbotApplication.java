package cloudclub.schedule.slackbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SlackbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlackbotApplication.class, args);
	}

}
