package lesson1.participant;

public class Robot implements Participant {

    private final String name;
    private final int jumpHeight;
    private final int maxRunLength;

    public Robot(String name, int jumpHeight, int maxRunLength) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.maxRunLength = maxRunLength;
    }

    @Override
    public int run() {
        System.out.printf("Робот %s бежит дистанцию %d%n", name, maxRunLength); // реализация абстрактного метода из интерфейса Participant
        return maxRunLength;                                                    // выступает в качестве некоего геттера для поля maxRunLength
    }

    @Override
    public int jump() {
        System.out.printf("Робот %s делает прыжок %d%n", name, jumpHeight); // реализация абстрактного метода из интерфейса Participant
        return jumpHeight;                                                  // выступает в качестве некоего геттера для поля jumpHeight
    }

    @Override
    public String toString() {                   // переопределили метод toString для вывода в консоль более детальной информации
        return "Robot{" +
                "name='" + name + '\'' +
                ", jumpHeight=" + jumpHeight +
                ", maxRunLength=" + maxRunLength +
                '}';
    }

}