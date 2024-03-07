package Week10;
import java.util.ArrayList;

public class TypeCastingCollection {

    public static void main(String[] args) {
        ArrayList<Object> data = new ArrayList<>();
        data.add("Hello");
        data.add(10);
        data.add(3.14);
        data.add(true);

        int successfulCasts = 0;

        for (Object obj : data) {
            try {
                String str = (String) obj;
                System.out.println("Successfully cast " + obj.getClass().getSimpleName() + " to String: " + str);
                successfulCasts++;
            } catch (ClassCastException e) {
                System.out.println("Error: Casting " + obj.getClass().getSimpleName() + " to String failed.");
            }

            // Repeat similar try-catch blocks for other desired casting attempts
            // For example:
            try {
                Integer num = (Integer) obj;
                System.out.println("Successfully cast " + obj.getClass().getSimpleName() + " to Integer: " + num);
                successfulCasts++;
            } catch (ClassCastException e) {
                System.out.println("Error: Casting " + obj.getClass().getSimpleName() + " to Integer failed.");
            }

            // ... and so on for Double, Boolean, etc.
        }

        System.out.println("Total successful casts: " + successfulCasts);
    }
}
