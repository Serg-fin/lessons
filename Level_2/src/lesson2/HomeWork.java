package lesson2;

public class HomeWork {

    private static final int REQUIRED_ARRAY_SIZE = 4;

    private static final String[][] CORRECT_DATA = new String[][] {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"},
    };

    private final static String[][] INCORRECT_SIZE_DATA = new String[][] {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11"},
            {"13", "14", "15", "16"},
    };

    private static final String[][] INCORRECT_VALUE_DATA = new String[][] {
            {"1", "2", "3", "не число"}, //вместо 0 указано не число
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"},
    };


    public static void main(String[] args) {
        try {
//            int result = sumArrayValues(CORRECT_DATA);
            int result = sumArrayValues(INCORRECT_SIZE_DATA);
//            int result = sumArrayValues(INCORRECT_VALUE_DATA);
            System.out.println("Array sum: " + result);
        } catch (MyArraySizeExeption e) {
            System.err.println("Некорректный размер массива");
            e.printStackTrace();
        } catch (MyArrayDataExeption e) {
            System.err.println("Некорректные данные в массиве");
            e.printStackTrace();
        }
    }

    private static int sumArrayValues(String[][] data) throws MyArraySizeExeption, MyArrayDataExeption {
        checkArraySize(data);

        int sumResult = 0;

        for (int rowIndex = 0; rowIndex < data.length; rowIndex++) {
            String[] row = data[rowIndex];
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                String value = row[colIndex];
                try {
                    sumResult += Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataExeption(value, rowIndex, colIndex);


                }
            }
        }
        return sumResult;
    }

    private static void checkArraySize(String[][] data) {
        if (data.length != REQUIRED_ARRAY_SIZE) {
            throw new MyArraySizeExeption();
        }
        for (String[] row : data) {
            if (row.length != REQUIRED_ARRAY_SIZE) {
                throw new MyArraySizeExeption();
            }
        }
    }

}


