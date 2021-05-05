package lesson7;

public class Cat {
    private String name;
    private int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        System.out.println("Кот начал есть");
        p.decreaseFood(appetite);  // здесь произвели инкапсуляцию (здесь "appetite", а в методе decreaseFood класса Plate это переменнная "amount")
    }

}
