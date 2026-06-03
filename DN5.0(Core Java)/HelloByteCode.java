public class HelloByteCode {

    public void greet() {
        System.out.println("Hello from bytecode!");
    }
    public int add(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) {
        HelloByteCode obj = new HelloByteCode();
        obj.greet();
        int result = obj.add(5, 3);
        System.out.println("Sum = " + result);
    }
}