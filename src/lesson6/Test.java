package lesson6;

public class Test {            // здесь создаем наши объекты

    public static void main(String[] args) {

        int minCat = 0; // Минимальное число для диапазона кота
        int maxCat = 200; // Максимальное число для диапазона кота
        int rnd1 = rnd1(minCat, maxCat);
        int rnd2 = rnd2(minCat, maxCat);

        int minDog = 10; // Минимальное число для диапазона собаки
        int maxDog = 500; // Максимальное число для диапазона собаки
        int rnd3 = rnd3(minDog, maxDog);
        int rnd4 = rnd4(minDog, maxDog);

        System.out.println("Сгенерированные числа кота: " + rnd1 + " " + rnd2);
        System.out.println("Сгенерированные числа собаки: " + rnd3 + " " + rnd4);

        Cat cat = new Cat("Мурзик", rnd1, rnd2); // задаем параметры для новых объектов
        Dog dog = new Dog("Бобик", rnd3, rnd4);

        System.out.println("-----КОТЫ-----");
        cat.printInfo();
        cat.swim();
        cat.running();

        System.out.println();
        System.out.println("-----СОБАКИ-----");
        dog.printInfo();
        dog.swim();
        dog.running();
    }

    public static int rnd1(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
    public static int rnd2(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
    public static int rnd3(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
    public static int rnd4(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
