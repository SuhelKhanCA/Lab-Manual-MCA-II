import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.*;

class CustomExceptionMemErr extends Throwable{
    public CustomExceptionMemErr(String message){
        super (message);
    }
}

public class w9q2 {
    public static void main(String[] args) throws CustomExceptionMemErr{
        List<byte[]> list = new ArrayList<>();
        try{
            //Creating instance of memory bean
            MemoryMXBean mb = ManagementFactory.getMemoryMXBean();

            //Getting max mem used by JVM
            long maxMem =  Runtime.getRuntime().maxMemory();


            //Setting memory limit to 80% to ensure appropriate usage
            long memLimit = (long) (0.8 * maxMem);


            while(true){
                //Simulating intensive operation
                byte[] array = new byte[1000000]; // Allocate 1MB of memory
                list.add(array);

                long usedMem = mb.getHeapMemoryUsage().getUsed();

                if(usedMem >= maxMem){
                    //Terminating the program
                    throw new CustomExceptionMemErr("Memory usage exceeded! Terminating the program.");
                }
            }
        } catch (OutOfMemoryError o){
            throw new CustomExceptionMemErr("OutOfMemoryError occurred. Terminating the program.");
        }
    }
}
