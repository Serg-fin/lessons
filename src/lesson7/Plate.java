package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void decreaseFood(int appetite) { // метод поедания еды (уменьшает количество еды)

        food -= appetite;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {

        this.food = food;
    }
    public void addFood(int foodCount) { // метод добавления еды в тарелку
        this.food = foodCount;
    }

    public boolean isFoodEnough(int foodCount) {
        return getFood() >= foodCount;
    }
}
