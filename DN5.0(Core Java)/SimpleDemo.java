public class SimpleDemo {
    public int multiply(int a, int b) {
        return a * b;
    }
    public static void main(String[] args) {
        SimpleDemo obj = new SimpleDemo();
        int result = obj.multiply(4, 5);
        System.out.println("Result = " + result);
    }
}