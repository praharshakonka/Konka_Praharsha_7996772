import java.util.Scanner;
import java.util.Random;
public class NumberGuess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int number = rand.nextInt(100) + 1;
        int guess = 0;
        System.out.println("Welcome to Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100");
        while (guess != number) {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            if (guess > number) {
                System.out.println("Too high!");
            } else if (guess < number) {
                System.out.println("Too low!");
            } else {
                System.out.println("Correct! You guessed it.");
            }
        }
        sc.close();
    }
}   
