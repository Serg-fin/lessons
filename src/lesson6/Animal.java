package lesson6;

public class Animal {
    public  String name;
    public int raceLength;
    public int swimLength;

    public Animal(String name, int raceLength, int swimLength) {     // конструктор
        this.name = name;
        this.raceLength = raceLength; // длина забега
        this.swimLength = swimLength; // длина заплыва
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getRaceLength() {
        return raceLength;
    }

    public void setRaceLength(int raceLength) {

        this.raceLength = raceLength;
    }

    public int getSwimLength() {
        return swimLength;
    }

    public void setSwimLength(int swimLength) {

        this.swimLength = swimLength;
    }

    public void printInfo() {

        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name=" + name +
                ", raceLength=" + raceLength +
                ", swimLength=" + swimLength +
                '}';
    }
}
