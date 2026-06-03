import java.util.Scanner;
public class GradeCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks out of 100: ");
        double marks = sc.nextDouble();
        String grade;
        if (marks >= 90 && marks <= 100) {
            grade = "A";
        } else if (marks >= 80 && marks < 90) {
            grade = "B";
        } else if (marks >= 70 && marks < 80) {
            grade = "C";
        } else if (marks >= 60 && marks < 70) {
            grade = "D";
        } else if (marks >= 0 && marks < 60) {
            grade = "F";
        } else {
            grade = "Invalid marks! (Enter 0–100)";
        }
        System.out.println("Grade: " + grade);
        sc.close();
    }
}