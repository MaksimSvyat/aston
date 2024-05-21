import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 30);
        employees[1] = new Employee("Petrov Petr", "Head groom",
                "petr@mailbox.com", "892312313", 300000, 54);
        employees[2] = new Employee("Sidorov Sidor", "QA",
                "sidr@mailbox.com", "892312314", 50000, 25);
        employees[3] = new Employee("Filipov Filip", "AQA",
                "fil22@mailbox.com", "892312315", 150000, 27);
        employees[4] = new Employee("Olegov Oleg", "SEO",
                "lucky@mailbox.com", "777777777", 15000000, 33);

        Arrays.stream(employees).forEach(Employee::printInfo);

        Park park = new Park("Divo-ostrov");

        Park.Attraction blueFire = new Park.Attraction("Blue Fire", "10:00-21:00", 1000.0);
        Park.Attraction bigRussianSlide = new Park.Attraction("Big Russian slide", "10:00-22:00",
                1200.0);

        park.addAttraction(blueFire);
        park.addAttraction(bigRussianSlide);

        System.out.println(park);
    }
}