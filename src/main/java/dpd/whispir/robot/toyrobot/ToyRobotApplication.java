package dpd.whispir.robot.toyrobot;

import dpd.whispir.robot.toyrobot.application.ConsoleInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class ToyRobotApplication {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = SpringApplication.run(ToyRobotApplication.class, args);

		ConsoleInterface consoleInterface = context.getBean(ConsoleInterface.class);
		consoleInterface.runApplication();
	}
}
