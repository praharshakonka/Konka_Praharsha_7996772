package BytecodeDemo;
public class Sample {
    public int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        Sample s = new Sample();
        System.out.println("Result = " + s.multiply(5, 4));
    }
}