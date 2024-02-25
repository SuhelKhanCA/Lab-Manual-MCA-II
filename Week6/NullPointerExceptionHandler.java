import java.util.Scanner;

public class NullPointerExceptionHandler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("Enter an option (1 for a, 2 for b or 3 for c): ");
        option = scanner.nextInt();
        switch (option) {
            case 1:
                a();
                break;
            case 2:
                b();
                break;
            case 3:
                c();
                break;
            default:
                System.out.println("Invalid Option");
        }
        scanner.close();
    }

    public static void a() {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void b() {
        String str = null;
        System.out.println(str.length());
    }

    public static void c() {
        String inputStr = "Hello World!";

        if (inputStr != null) {
            System.out.println(inputStr.length());
        } else {
            System.out.println("String is null.");
        }
    }
}
