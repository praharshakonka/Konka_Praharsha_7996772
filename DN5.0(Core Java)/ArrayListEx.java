import java.util.ArrayList;
import java.util.Scanner;
public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("How many number of students do you want to add: ");
            int n = sc.nextInt();
            sc.nextLine(); // Consume newline
            for (int i = 1; i <= n; i++) {
                System.out.print("Enter name of student " + i + ": ");
                String name = sc.nextLine();
                studentNames.add(name);
            }
            System.out.println("\nList of Student Names:");
            for (String name : studentNames) {
                System.out.println(name);
            }
        }
    }
}