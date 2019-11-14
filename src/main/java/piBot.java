import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;

import java.io.*;
import java.util.Scanner;

public class piBot {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter port: ");
        Maze.start(input.nextInt());
        System.out.println("Starting...");

        Gpio.wiringPiSetup();
        SoftPwm.softPwmCreate(Move.LeftForward, 0, 100);
        SoftPwm.softPwmCreate(Move.LeftBackward, 0, 100);
        SoftPwm.softPwmCreate(Move.RightForward, 0, 100);
        SoftPwm.softPwmCreate(Move.RightBackward, 0, 100);
        SoftPwm.softPwmCreate(Move.ledBreak, 0, 100);

        for (char i : Maze.path()) {
            if (i == '1') {
                Move.southWest();
                Move.thisLong(600);
            } else if (i == '2') {
                Move.south();
                Move.thisLong(600);
            } else if (i == '3') {
                Move.southEast();
                Move.thisLong(600);
            } else if (i == '4') {
                Move.west();
                Move.thisLong(470);
            } else if (i == '6') {
                Move.east();
                Move.thisLong(470);
            } else if (i == '7') {
                Move.northWest();
                Move.thisLong(600);
            } else if (i == '8') {
                Move.north();
                Move.thisLong(650);
            } else if (i == '9') {
                Move.northEast();
                Move.thisLong(600);
            } else {
                Move.thisLong(0);
            }
        }
    }
}

