package dpd.whispir.robot.toyrobot.application;

import dpd.whispir.robot.toyrobot.application.model.Command;
import dpd.whispir.robot.toyrobot.domain.model.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A  <code>ConsoleInterface</code> is a user interface specifically designed for console usage
 */
@Component
public class ConsoleInterface implements UserInterfacePort {

    @Autowired
    private ToyRobotNavigationApplicationInterface toyRobotNavigationApplication;

    private BufferedReader in;

    public ConsoleInterface() {
        this.in = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void showReport(Robot robot) {
        System.out.println("Output: " + robot);
    }

    private void runToyRobotNavigator() throws IOException {
        Command command;
        String line = in.readLine().toUpperCase().trim();

        if (line.startsWith("PLACE ")) {
            command = new Command("PLACE", line.substring(5).split(","));
        } else {
            command = new Command(line);
        }

        toyRobotNavigationApplication.handle(command, this);
    }

    public void runApplication() throws IOException {
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("           TOY ROBOT NAVIGATOR");
        System.out.println("----------------------------------------");
        System.out.println();

        while (1 == 1) {
            this.runToyRobotNavigator();
        }
    }
}
