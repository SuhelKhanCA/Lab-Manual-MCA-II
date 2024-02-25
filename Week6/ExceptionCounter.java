import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionCounter {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ExceptionCounter <file_path> in the command line");
            return;
        }

        String filePath = args[0];
        try {
            int count = countExceptions(filePath);
            System.out.println("Total number of exceptions found: " + count);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static int countExceptions(String filePath) throws IOException {
        int exceptionCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("catch") || line.contains("throws") || line.contains("throw") ||
                        line.contains("try") || line.contains("finally")) {
                    exceptionCount++;
                }
            }
        }
        return exceptionCount;
    }
}
