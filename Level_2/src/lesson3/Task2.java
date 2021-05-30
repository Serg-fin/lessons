package lesson3;

import java.util.Set;

public class Task2 {

    public static void main(String[] args) {
        IPhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "111-11-11");
        phoneBook.add("Петров", "222-22-22");
        phoneBook.add("Сидоров", "333-33-33");
        phoneBook.add("Петров", "555-55-55");

        Set<String> allSurnames = phoneBook.getAllSurnames();
        for (String surname : allSurnames) {
            Set<String> phones = phoneBook.get(surname);
            System.out.printf("%s: %s%n", surname, phones);
        }
    }
}
