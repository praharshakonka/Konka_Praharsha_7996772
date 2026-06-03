import java.util.Scanner;
public class CheckEvenorOdd {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Please enter a number : ");
        int n=sc.nextInt();

        if(n%2==0)
        {
            System.out.println("Even");
        }
        else
        {
            System.out.println("Odd");
        }
    sc.close();
    }
}
