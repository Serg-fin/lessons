package lesson6;

public class Dog extends Animal {

    public Dog(String name, int raceLength, int swimLength) {
        super(name, raceLength, swimLength);
    }

    public void running() {
        int max = 500;
        if (getRaceLength() <= max) {
            System.out.println(getName() + " пробежал " + getRaceLength() + " м ");
        } else
            System.out.println(getName() + " столько не пробежит ");
    }

    public void swim() {
        int max = 10;
        if (getSwimLength() <= max) {
            System.out.println(getName() + " проплыл " + getSwimLength() + " м ");
        } else
            System.out.println(getName() + " столько не проплывет ");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", raceLength='" + raceLength + '\'' +
                ", swimLength='" + swimLength + '\'' +
                '}';
    }
}