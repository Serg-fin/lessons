package lesson2;

public class MyArraySizeExeption extends IllegalArgumentException {

    public MyArraySizeExeption() {
        super("Invalid array size, required 4x4");
    }
}
