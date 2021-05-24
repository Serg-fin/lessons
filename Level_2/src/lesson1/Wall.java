package lesson1;

public class Wall {

    public static void main(String[] args) {
        mustRun();
        mustJump();
    }

    public static boolean mustRun() {
        return Cat.canRun() < 100;
        }



    public static void mustJump() {

        if (Cat.canJump() <= 200) {
            System.out.println("Кот перепрыгнул стену");
        } else {
            System.out.println("Кот не перепрыгнул стену");
        }

    }
}

