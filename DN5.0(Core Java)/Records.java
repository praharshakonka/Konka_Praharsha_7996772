import java.util.List;
import java.util.stream.Collectors;
record Person(String name, int age) {}
public class Records {
    public static void main(String[] args) {
        Person p1 = new Person("Praha", 20);
        Person p2 = new Person("Saha", 17);
        Person p3 = new Person("Raina", 25);
        System.out.println("Person Records:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        List<Person> people = List.of(p1, p2, p3);
        List<Person> adults = people.stream()
                                    .filter(person -> person.age() >= 18)
                                    .collect(Collectors.toList());
        System.out.println("\nAdults (Age 18 and above):");
        adults.forEach(System.out::println);
    }
}