package ReflectioninJava; 
import java.lang.reflect.*;

public class ReflectionDemo {

    public static void main(String[] args) {

        try {

            Class<?> clazz = Class.forName("ReflectioninJava.Student");

            System.out.println("Class Name: " + clazz.getName());
            System.out.println("\nMethods:");

            Method[] methods = clazz.getDeclaredMethods();

            for (Method method : methods) {

                System.out.print("Method: " + method.getName());

                Class<?>[] params = method.getParameterTypes();

                System.out.print(" (Parameters: ");

                for (Class<?> param : params) {
                    System.out.print(param.getSimpleName() + " ");
                }

                System.out.println(")");
            }
            System.out.println("\n--- Invoking Methods ---");
            Object obj = clazz.getDeclaredConstructor().newInstance();
            Method m1 = clazz.getMethod("sayHello");
            m1.invoke(obj);
            Method m2 = clazz.getMethod("greet", String.class);
            m2.invoke(obj, "Praha");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}