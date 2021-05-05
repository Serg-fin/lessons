package lesson7;

public class FeedTheCat {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 105);
        Plate plate = new Plate(100);
//        System.out.println();
        plate.info();
        cat.eat(plate);
        plate.info();
//        plate.setF
    }
}
