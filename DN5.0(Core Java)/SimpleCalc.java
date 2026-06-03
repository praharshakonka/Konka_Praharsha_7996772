import java.util.Scanner;
class SimpleCalc {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        System.out.print("Enter operator (+, -, *, /): ");
        char op = sc.next().charAt(0);

        int result = 0;
        switch(op) {

            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                result = num1 / num2;
                break;
        }

        System.out.println("Result = " + result);
        sc.close();
    }
}