package BytecodeDemo.decompiled;
public class Sample {

    public int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        Sample s = new Sample();
        System.out.println(s.multiply(4, 5));
    }
}