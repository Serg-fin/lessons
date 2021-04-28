package lesson5;

public class Employee {                   // Здесь я создаю поля (они всегда private!!!)
    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;
    private int phone;
    private int salary;
    private int age;

    public Employee(String firstName, String lastName, String patronymic, String email, int phone, int salary, int age) {           // Это конструктор
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void jump() {
        System.out.println("Человек" + firstName + "прыгнул");
    }
}





//    public static void main(String[] args) {
//
//        Employee employee_1 = new Employee();
//        employee_1.firstName = "Иван";
//        System.out.println(employee_1);
//    }

