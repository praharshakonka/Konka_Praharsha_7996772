import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class FileWriting {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String text = sc.nextLine();

            try (FileWriter writer = new FileWriter("output.txt")) {
                writer.write(text);
                System.out.println("Data has been written to output.txt successfully.");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}