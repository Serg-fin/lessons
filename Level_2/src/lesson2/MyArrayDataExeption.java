package lesson2;

public class MyArrayDataExeption extends RuntimeException {

    public MyArrayDataExeption(String cellValue, int rowIndex, int colIndex) {
        super(String.format("Invalid value '%s' in array cell[%d][%d], required integer", cellValue, rowIndex, colIndex));
    }
}
