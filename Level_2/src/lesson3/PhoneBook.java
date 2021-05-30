package lesson3;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBook implements IPhoneBook {

    private final Map<String, Set<String>>  phonesBySurname;

    public PhoneBook() {
        phonesBySurname = new TreeMap<>();
    }
    @Override
    public void add(String surname, String phoneNumber) { // метод добавления номера телефона
        Set<String> phones = getPhones(surname);
        phones.add(phoneNumber);
    }

    private Set<String> getPhones(String surname) {
        return phonesBySurname.computeIfAbsent(surname, key -> new HashSet<>()); // метод поиска номера телефона по фамилии
    }

    @Override
    public Set<String> get(String surname) {
        return getPhones(surname);
    }

    @Override
    public Set<String> getAllSurnames() {
        return phonesBySurname.keySet();
    }
}
