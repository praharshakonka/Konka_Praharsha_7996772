import java.util.HashMap;
import java.util.Scanner;
public class HashMapEx {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("How many student entries do you want to add: ");
            int n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                System.out.print("\nEnter Student ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();
                students.put(id, name);
            }
            System.out.print("\nEnter Student ID to search: ");
            int searchId = sc.nextInt();
            if (students.containsKey(searchId)) {
                System.out.println("Student Name: " + students.get(searchId));
            } else {
                System.out.println("Student ID not found.");
            }
        }
    }
}