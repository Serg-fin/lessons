package lesson6;

public class Cat extends Animal {

    public Cat(String name, int raceLength, int swimLength) {

        super(name, raceLength, swimLength);
    }
    public void running() {
        int max = 200;
        if (getRaceLength() <= max) {
            System.out.println(getName() + " пробежал " + getRaceLength() + " м ");
        } else
            System.out.println(getName() + " столько не пробежит ");
    }
    public void swim() {
        if (getRaceLength() != 0) {
            System.out.println(getName() + " не умеет плавать ");
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", raceLength='" + raceLength + '\'' +
                ", swimLength='" + swimLength + '\'' +
                '}';
    }
}
