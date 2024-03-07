package Week10;

public class TypeCastingExamples { // Q2

    public static void main(String[] args) {

        // Scenario 1: Casting incompatible types
        Object obj = new Object();
        try {
            String str = (String) obj; // ClassCastException expected
            System.out.println("Successfully cast object to string: " + str);
        } catch (ClassCastException e) {
            System.out.println("Error: Cast failed due to incompatible types. (Object to String)");
        }

        // Scenario 2: Upcasting (safe)
        int num = 10;
        double dNum = (double) num; // Safe upcast
        System.out.println("Successfully upcast int to double: " + dNum);

        // Scenario 3: Downcasting with instanceof check (safe)
        Object obj2 = new String("Hello");
        if (obj2 instanceof String) {
            String str2 = (String) obj2; // Safe downcast
            System.out.println("Successfully downcast object to string: " + str2);
        } else {
            System.out.println("Cast not possible: object is not of type String.");
        }

        // Scenario 4: Downcasting without instanceof check (risky)
        Object obj3 = new Integer(10); // Integer is an older class, not recommended today
        try {
            int num3 = (int) obj3; // Risky downcast, may throw ClassCastException
            System.out.println("Successfully downcast object to int: " + num3);
        } catch (ClassCastException e) {
            System.out.println("Error: Cast failed due to incompatible types. (Object to int)");
        }
    }
}
