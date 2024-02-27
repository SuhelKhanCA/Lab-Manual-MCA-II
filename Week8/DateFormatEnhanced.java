package Week8;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatEnhanced {

    public static class DateParseException extends Exception {
        public DateParseException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) throws DateParseException {
        // Replace with your desired date format
        String format = "yyyy-MM-dd";
        String dateString = "2024-02-29"; 

        DateFormat formatter = new SimpleDateFormat(format);

        try {
            formatter.parse(dateString);
            System.out.println("Date parsed successfully!");
        } catch (ParseException e) {
            throw new DateParseException("Failed to parse date: " + e.getMessage());
        } finally {
            System.out.println("Date formatter is not explicitly closed as it doesn't require it.");
        }
    }
}


