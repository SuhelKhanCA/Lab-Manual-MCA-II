import java.util.ArrayList;
import java.util.List;

public class w9q3 {
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("545");
        strings.add("989");
        strings.add("AMU");
        strings.add("azam");


        int count = 0;

        // Attempt conversion for each string
        for (String str : strings) {
            try {
                // Convert string to integer
                int num = Integer.parseInt(str);

                System.out.println("Successfully converted: " + num);

                count++;
            } catch (NumberFormatException e) {
                System.out.println("Error converting '" + str + "' to integer. It is not an integer.");
            }
        }

        System.out.println("Total successfully converted integers: " + count);
    }
}
