import com.pi4j.wiringpi.SoftPwm;

class Move {
    // Use these pins
    public static final int LeftForward = 0; // GPIO Header 11 / WiringPi pin 0;
    public static final int LeftBackward = 2; // WiringPi pin 2; GPIO Header 13
    public static final int RightForward = 4; // WiringPi pin 4 / GPIO Header 16
    public static final int RightBackward = 5;// WiringPi pin 5; / GPIO Header 18

    public static void north() {
        System.out.println("Driving north");
        SoftPwm.softPwmWrite(LeftForward, 100);
        SoftPwm.softPwmWrite(RightForward, 100);
    }

    public static void south() {
        System.out.println("Driving south");
        SoftPwm.softPwmWrite(LeftBackward, 100);
        SoftPwm.softPwmWrite(RightBackward, 100);
    }

    public static void east() {
        System.out.println("Driving east");
        SoftPwm.softPwmWrite(LeftForward, 100);
        SoftPwm.softPwmWrite(RightBackward, 100);
    }

    public static void west() {
        System.out.println("Driving west");
        SoftPwm.softPwmWrite(LeftBackward, 100);
        SoftPwm.softPwmWrite(RightForward, 100);
    }

    public static void northEast() {
        System.out.println("Driving NorthEast");
        SoftPwm.softPwmWrite(LeftForward, 100);
        SoftPwm.softPwmWrite(RightBackward, 0);
    }

    public static void southEast() {
        System.out.println("Driving SouthEast");
        SoftPwm.softPwmWrite(LeftBackward, 100);
        SoftPwm.softPwmWrite(RightForward, 0);
    }

    public static void northWest() {
        System.out.println("Driving NorthWest");
        SoftPwm.softPwmWrite(LeftBackward, 0);
        SoftPwm.softPwmWrite(RightForward, 100);
    }

    public static void southWest() {
        System.out.println("Driving SouthWest");
        SoftPwm.softPwmWrite(LeftForward, 0);
        SoftPwm.softPwmWrite(RightBackward, 100);
    }

    public static void stop() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Pause");
        SoftPwm.softPwmWrite(LeftForward, 0);
        SoftPwm.softPwmWrite(LeftBackward, 0);
        SoftPwm.softPwmWrite(RightForward, 0);
        SoftPwm.softPwmWrite(RightBackward, 0);
    }
}
