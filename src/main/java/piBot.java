import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;
import java.io.*;
import java.util.Scanner;

public class piBot {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Start server and receive Maze File on RPI
        Scanner input = new Scanner(System.in);
        Maze.start(input.nextInt());
        System.out.println("Starting...");
        Gpio.wiringPiSetup();
        SoftPwm.softPwmCreate(Move.LeftForward, 0, 100);
        SoftPwm.softPwmCreate(Move.LeftBackward, 0, 100);
        SoftPwm.softPwmCreate(Move.RightForward, 0, 100);
        SoftPwm.softPwmCreate(Move.RightBackward, 0, 100);
        for (char p : Maze.path()) {
            if (p == 'N') {
                Move.north();
                Move.stop();
            } else if (p == 'S') {
                Move.south();
                Move.stop();
            } else if (p == 'W') {
                Move.west();
                Move.stop();
            } else if (p == 'E') {
                Move.east();
                Move.stop();
            } else {
                Move.stop();
            }
        }
    }
}

