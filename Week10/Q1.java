package Week10;import java.util.ArrayList;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {
        // Create a list with objects of different types
        List<Object> list = new ArrayList<>();
        list.add("Hello");
        list.add(123);
        list.add(45.67);
        list.add(true);

        int successfulCasts = 0;

        // Attempt to cast each object to a String
        for (Object obj : list) {
            try {
                String str = (String) obj;
                System.out.println("Successfully casted " + obj + " to a String");
                successfulCasts++;
            } catch (ClassCastException e) {
                System.out.println("Error: Cannot cast " + obj + " to a String");
            }
        }

        System.out.println("Number of successful casts: " + successfulCasts);
    }
}
