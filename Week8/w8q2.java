import java.io.IOException;
import java.net.*;
import java.net.http.HttpConnectTimeoutException;
import java.sql.SQLOutput;

public class w8q2 {

    private static class CustomException extends Exception{
        public CustomException(String exceptionMessage){
            super(exceptionMessage);
        }
    }

    public static void main(String[] args) throws CustomException{
        if(args.length == 0){
            throw new CustomException("In the terminal enter the URL - java w8q2 <url with https(s)>.");
        }

        try{
            URL u1 = new URL(args[0]);
            try{
                URLConnection uc = u1.openConnection();
                try{
                    HttpURLConnection huc = (HttpURLConnection)uc;
                    int responseCode = huc.getResponseCode();
                    if(responseCode == 200) {
                        System.out.println("Connection to " + args[0] + " was successful!");
                    } else if(responseCode == 404){
                        throw new CustomException("The requested page does not exist.");
                    } else if(responseCode == 403) {
                        throw new CustomException("Access denied: The server understood the request, but is refusing to authorize it.");
                    } else {
                        throw new CustomException("Some error occured! Response Code: " + responseCode);
                    }
                } catch(ConnectException c){
                    throw new CustomException("ERROR couldn't connect: " + c.getMessage());
                }
            } catch(IOException i) {
                throw new CustomException("ERROR IOException: " + i.getMessage());
            }
        } catch(MalformedURLException m) {
            throw new CustomException("ERROR " + m.getMessage());
        }
    }
}
