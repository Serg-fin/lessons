package lesson5;

public class TestEmployee {

    public static void main(String[] args) {
        Employee[] employeesArray = new Employee[5];
        employeesArray[0] = new Employee("Иванов", "Иван", "Иванович", "Engineer","ivanov@mail.ru", 111111111, 10000, 41);
        employeesArray[1] = new Employee("Петров", "Петр", "Петрович", "Engineer","petrov@mail.ru", 222222222, 20000, 30);
        employeesArray[2] = new Employee("Сидоров", "Сидр", "Сидорович", "Engineer","sidorov@mail.ru", 333333333, 30000, 40);
        employeesArray[3] = new Employee("Прохоров", "Прохор", "Прохорович", "Engineer","petrov@mail.ru", 444444444, 40000, 50);
        employeesArray[4] = new Employee("Васильев", "Василий", "Васильевич", "Engineer","petrov@mail.ru", 555555555, 50000, 60);

        for (Employee employee : employeesArray) {
            if (employee.getAge() > 40 ) {
                employee.printInfo();
            }
        }
    }
}
