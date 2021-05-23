package lesson2;

public class BasicDesigns {

    public static void main(String[] args) {
        within10and20(-5, 10);
        comparingNumbers(-2);
        comparingNum(4);
        counter("Java it's cool!!!", 5);
    }

    public static boolean within10and20(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            System.out.println(sum + " true");
            return true;
        } else {
            System.out.println(sum + " false");
            return false;
        }
    }

    public static int comparingNumbers(int a) {
        if (a >= 0) {
            System.out.println("Передано положительное число: " + a);
            return a;
        } else {
            System.out.println("Передано отрицательное число: " + a);
            return a;
        }
    }

    public static boolean comparingNum(int a) {
        if (a >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void counter(String someText, int a) {
        for (int b = 0; b < a; b++) {
            System.out.println(someText);
        }
    }
}



