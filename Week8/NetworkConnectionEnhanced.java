package Week8;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkConnectionEnhanced {

    public static class NetworkConnectionException extends Exception {
        public NetworkConnectionException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) throws NetworkConnectionException {
        String urlString = "http://www.thisurldoesnotexist.com"; 

        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(urlString).openConnection();
            connection.connect();
            int responseCode = connection.getResponseCode(); 
            System.out.println("Response code: " + responseCode);
        } catch (IOException e) {
            throw new NetworkConnectionException("Failed to establish network connection: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            System.out.println("Network connection closed.");
        }
    }
}


