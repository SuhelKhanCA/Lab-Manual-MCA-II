package Week10;
import java.util.ArrayList;

public class TypeCastingCollection3 { // Question no. 3

    public static void main(String[] args) {
        ArrayList<Object> data = new ArrayList<>();
        data.add("Hello");
        data.add(10);
        data.add(3.14);
        data.add(true);
        data.add(new Double(22.5)); // Wrapper class object
        data.add(new Character('A')); // Character object

        int successfulCasts = 0;

        for (Object obj : data) {
            // Casting attempts to String, Integer, Double
            try {
                String str = (String) obj;
                System.out.println("Successfully cast " + obj.getClass().getSimpleName() + " to String: " + str);
                successfulCasts++;
            } catch (ClassCastException e) {
                System.out.println("Error: Casting " + obj.getClass().getSimpleName() + " to String failed.");
            }

            try {
                Integer num = (Integer) obj;
                System.out.println("Successfully cast " + obj.getClass().getSimpleName() + " to Integer: " + num);
                successfulCasts++;
            } catch (ClassCastException e) {
                System.out.println("Error: Casting " + obj.getClass().getSimpleName() + " to Integer failed.");
            }

            try {
                Double dNum = (Double) obj;
                System.out.println("Successfully cast " + obj.getClass().getSimpleName() + " to Double: " + dNum);
                successfulCasts++;
            } catch (ClassCastException e) {
                System.out.println("Error: Casting " + obj.getClass().getSimpleName() + " to Double failed.");
            }
        }

        System.out.println("Total successful casts: " + successfulCasts);
    }
}
