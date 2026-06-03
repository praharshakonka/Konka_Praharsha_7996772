public class TypeCast{
    public static void main(String[] args)
    {
        double num1 = 45.96;
        int intValue = (int) num1;
        System.out.println("Double Value before Casting : " + num1);
        System.out.println("After Casting double to int : " + intValue);
        int num2 = 25;
        double doubleValue = (double) num2;
        System.out.println("Integer Value before Casting : " + num2);
        System.out.println("After Casting int to double : " + doubleValue);
    }
}