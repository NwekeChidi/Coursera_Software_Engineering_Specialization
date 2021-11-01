
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Tester {
    public void testLogEntry(){
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        
        LogEntry le1 = new LogEntry("1.2.200.4", new Date(), "example request 1", 200, 400);
        System.out.println(le1);
    }
}
