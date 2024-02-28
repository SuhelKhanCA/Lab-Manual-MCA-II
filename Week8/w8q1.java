import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

class DatabaseConnectionException extends Exception {
    public DatabaseConnectionException(String message){
        super(message);
    }
}

public class w8q1 {
    private static final java.lang.String DB_URL = "jdbc:mysql://localhost:3306/azam";
    private static final java.lang.String U_Name = "roo"; //Deliberately entered wrong password to trigger the exception
    private static final java.lang.String PASS = "azam";
    private static final Logger log = Logger.getLogger(w8q1.class);

    public static void main(String[] args) throws DatabaseConnectionException{
        try(Connection conn = DriverManager.getConnection(DB_URL, U_Name, PASS))
        {
            System.out.println(conn);
        } catch (SQLException s) {
            log.error("Database Exception Occurred: " + s.getMessage());
            throw new DatabaseConnectionException("Database Exception Occurred: " + s.getMessage());
        } finally {
            log.info("Database Connection Closed");
        }


    }
}
