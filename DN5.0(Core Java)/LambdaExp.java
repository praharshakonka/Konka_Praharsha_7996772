import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class LambdaExp{
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Praha");
        names.add("Saha");
        names.add("Tilak");
        names.add("Raina");
        System.out.println("Original List:");
        System.out.println(names);
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
        System.out.println("\nSorted List:");
        System.out.println(names);
    }
}