import java.io.*;

public class w9q1 {
    public static void main(String[] args) throws CustomException{
        try(FileReader fr = new FileReader(args[0])){
            BufferedReader br = new BufferedReader(fr);
        } catch(IOException i){
                throw new CustomException("ERROR: File not found");
            } finally {
            System.out.println("File Closed!");
        }
    }
}
