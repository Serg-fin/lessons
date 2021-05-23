package lesson3;

import java.util.Arrays;

public class HomeWork3 {
    public static void main(String[] args) {
        invertArray();
        fillArray();
        changeArray();
        fillDiagonal();
        initArray();
        minMax();
        checkBalance();
        task8();
    }

    public static void invertArray() {
        int[] array = {0, 1, 0, 1, 0, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            if (a < 6) {
                arr[i] = a * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    public static void fillDiagonal() {
        int[][] arr = new int[5][5];
        int lastIndex = arr.length -1;
        for (int i = 0; i < 5; i++) {
            arr[i][i] = arr [i] [lastIndex - i] = 1;
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }

    public static void initArray() {
        int length = 5;
        int initialValue = 7;
        int[] array = initArray(length, initialValue);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    private static int[] initArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static void minMax() {
        int[] array = {8, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("min " + min);
        System.out.println("max " + max);
    }
    public static void checkBalance() {
        System.out.println(checkBalance(new int[] {2, 2, 2, 1, 2, 2, 10, 1}));
    }
    private static boolean checkBalance(int[] array) {
        System.out.println();
        boolean result = false;
        int leftSum = 0;
        int rightSum = sum(array, 0, array.length);
        for (int i =0; i < array.length; i++) {
            leftSum += array[i];
            rightSum -= array[i];
            if (leftSum == rightSum) {
                System.out.println("Common sum = " + leftSum + "; index = " + i);
                result = true;
                break;
            }
        }
        System.out.println("-----");
        return result;
    }
    private static int sum(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static void task8() {
        System.out.println();
        shiftArray(new int[] {1, 2, 3, 4, 5}, 0);
        shiftArray(new int[] {1, 2, 3, 4, 5}, 1);
        shiftArray(new int[] {1, 2, 3, 4, 5}, 2);
        shiftArray(new int[] {1, 2, 3, 4, 5}, 5);
        shiftArray(new int[] {1, 2, 3, 4, 5}, 6);
        shiftArray(new int[] {1, 2, 3, 4, 5}, -1);
        shiftArray(new int[] {1, 2, 3, 4, 5}, -2);
        shiftArray(new int[] {1, 2, 3, 4, 5}, -5);
        shiftArray(new int[] {1, 2, 3, 4, 5}, -6);
    }
    private static void shiftArray(int[] array, int n) {
        int shiftNumber = n % array.length;
        if (shiftNumber < 0) {
            shiftLeft(array, Math.abs(shiftNumber));
        }
        else {
            shiftRight(array, shiftNumber);
        }
        System.out.println(Arrays.toString(array) + "; shiftNumber = " + n);
    }
    private static void shiftRight(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int lastValue = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--) {
                array [j] = array[j - 1];
            }
            array[0] = lastValue;
        }
    }
    private static void shiftLeft(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int firstValue = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = firstValue;
        }
    }
}