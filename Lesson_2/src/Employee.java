public class Employee {
    private final String fullName;
    private final String position;
    private final String email;
    private final String phone;
    private final double salary;
    private final int age;

    public Employee(String fullName, String position, String email, String phone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Full Name: " + fullName + "\n"
                + "Position: " + position + "\n"
                + "Email: " + email + "\n"
                + "Phone: " + phone + "\n"
                + "Salary: " + salary + "\n"
                + "Age: " + age + "\n";
    }
}
