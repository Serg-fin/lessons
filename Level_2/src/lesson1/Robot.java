package lesson1;

public class Robot {
    public static void main(String[] args) {
//        Wall.mustRun();
//        Wall.mustJump();
    }

    public static int robotRun() {
        int robotMaxRun = 100;
        System.out.println("Робот может бегать на " + robotMaxRun + " метров");
        return robotMaxRun;
    }

    public static int robotJump() {
        int robotMaxJump = 200;
        System.out.println("Кот может прыгать на " + robotMaxJump + " метров.");
        return robotMaxJump;
    }
}
