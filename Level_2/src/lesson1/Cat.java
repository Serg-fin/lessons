package lesson1;

public class Cat {

    public static void main(String[] args) {
        finish();
//        Wall.mustRun();
//        Wall.mustJump();
    }

    public static int canRun() {
        int catMaxRun = 100;
        System.out.println("Кот может бегать на " + catMaxRun + " метров");
        return catMaxRun;
    }


    public static int canJump() {
        int catMaxJump = 200;
        System.out.println("Кот может прыгать на " + catMaxJump + " метров.");
        return catMaxJump;
    }

    public static boolean finish() {
        if (Wall.mustRun() == true) {
            System.out.println("Кот пробежал дистанцию");
        }

    }
}
