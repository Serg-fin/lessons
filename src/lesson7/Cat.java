package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety; // значение которое показывает сыт ли наш кот

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean eat(Plate plate) { // с помощью этого метода мы анализируем можем ли кот покушать из тарелки или нет, т.е. достаточно ли еды
        String validateMessage = checkEat(plate);
        if (validateMessage != null) {
            System.out.println(validateMessage);
            return false;
        }
        doEat(plate);
        satiety = true;
        return true;
    }

    private String checkEat(Plate plate) {
        if ( !plate.isFoodEnough(appetite) ) {
            return "Food is not enouch in the plate!";
        }
        if (satiety) {
            return "Cat is already satiety!";
        }
        return null;
    }

    private void doEat(Plate plate) {
        plate.decreaseFood(appetite);  // здесь произвели инкапсуляцию
    }

    public boolean isSatiety() {
        return satiety;
    }
}
