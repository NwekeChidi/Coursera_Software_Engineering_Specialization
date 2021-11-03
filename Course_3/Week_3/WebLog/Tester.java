
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le1 = new LogEntry("1.2.100.4", new Date(), "example request 1", 300, 400);
        System.out.println(le1);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
    }
    
    public void testUniqIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        int uniqueIPs = la.countUniqueIPs();
        System.out.println("There are "+uniqueIPs+" unique IPs");
    }
    
    public void testPrintAllHigh(int num){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        la.printAllHigherThanNum(num);
    }
    
    public void testUniqueIpVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        System.out.println("Unique IP visits on Mar 24: "+
                la.uniqueIPVisitsOnDay("Mar 24").size());
        System.out.println("Unique IP visits on Sep 14: "+
                la.uniqueIPVisitsOnDay("Sep 14"));
    }
    
    public void testCountUniqRange(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        System.out.println("Unique IPs in range 200-299: "+
                la.countUniqueIPsInRange(200,299));
        System.out.println("Unique IPs in range 300-399: "+
                la.countUniqueIPsInRange(300,399));;
    }
    
    public void testCountVisitsPerIp(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        HashMap<String,Integer> counts = la.countVisitsPerIp();
        System.out.println(counts);
    }
}
