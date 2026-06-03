public class PatternMatching{
    public static void checkType(Object obj) {
        switch (obj) {
            case Integer i ->
                System.out.println("Integer value: " + i);
            case String s ->
                System.out.println("String value: " + s);
            case Double d ->
                System.out.println("Double value: " + d);
            case Boolean b ->
                System.out.println("Boolean value: " + b);
            case null ->
                System.out.println("Object is null");
            default ->
                System.out.println("Unknown type: " + obj.getClass().getSimpleName());
        }
    }
    public static void main(String[] args) {
        checkType(100);
        checkType("Hello Java 21");
        checkType(99.99);
        checkType(true);
        checkType(null);
        checkType(new StringBuilder("Test"));
    }
}