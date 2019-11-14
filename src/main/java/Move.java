import com.pi4j.wiringpi.SoftPwm;

interface Move {
    // Use these pins
    int LeftForward = 0; // GPIO Header 11
    int LeftBackward = 2; // GPIO Header 13
    int RightForward = 4; // GPIO Header 16
    int RightBackward = 5;// GPIO Header 18
    int ledBreak = 1; // GPIO Header 12


    static void north() {
        System.out.println("Driving north");
        SoftPwm.softPwmWrite(RightForward, 100);
        SoftPwm.softPwmWrite(LeftForward, 100);
    }

    static void south() {
        System.out.println("Driving south");
        SoftPwm.softPwmWrite(LeftBackward, 100);
        SoftPwm.softPwmWrite(RightBackward, 100);
        SoftPwm.softPwmWrite(ledBreak, 100);
    }

    static void east() {
        System.out.println("Driving east");
        SoftPwm.softPwmWrite(LeftForward, 100);
        SoftPwm.softPwmWrite(RightBackward, 100);
    }

    static void west() {
        System.out.println("Driving west");
        SoftPwm.softPwmWrite(LeftBackward, 100);
        SoftPwm.softPwmWrite(RightForward, 100);
    }

    static void northEast() {
        System.out.println("Driving NorthEast");
        SoftPwm.softPwmWrite(LeftForward, 100);
        SoftPwm.softPwmWrite(RightBackward, 0);
    }

    static void southEast() {
        System.out.println("Driving SouthEast");
        SoftPwm.softPwmWrite(LeftBackward, 100);
        SoftPwm.softPwmWrite(RightForward, 0);
    }

    static void northWest() {
        System.out.println("Driving NorthWest");
        SoftPwm.softPwmWrite(LeftBackward, 0);
        SoftPwm.softPwmWrite(RightForward, 100);
    }

    static void southWest() {
        System.out.println("Driving SouthWest");
        SoftPwm.softPwmWrite(LeftForward, 0);
        SoftPwm.softPwmWrite(RightBackward, 100);
    }

    static void thisLong(int duration) throws InterruptedException {
        Thread.sleep(duration);
        SoftPwm.softPwmWrite(LeftForward, 0);
        SoftPwm.softPwmWrite(LeftBackward, 0);
        SoftPwm.softPwmWrite(RightForward, 0);
        SoftPwm.softPwmWrite(RightBackward, 0);
        Thread.sleep(500);
        SoftPwm.softPwmWrite(ledBreak, 100);
        Thread.sleep(500);
        SoftPwm.softPwmWrite(ledBreak, 0);
    }
}
