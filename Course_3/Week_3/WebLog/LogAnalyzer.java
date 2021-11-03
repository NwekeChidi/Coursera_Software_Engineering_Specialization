
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource(filename);
         WebLogParser wb = new WebLogParser();
         for (String s : fr.lines()){
             LogEntry le = wb.parseEntry(s);
             records.add(le);
            }
     }
     
     public int countUniqueIPs(){
         // uniqueIPs starts as an empty list
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         // for each element le in record
         for (LogEntry le : records){
             // ipAddr is le's ipAddress
             String ipAddr = le.getIpAddress();
             // if ipAddr is not in uniqueIps
             if (!uniqueIPs.contains(ipAddr)){
                 // add ipAddr to uniqueIps
                 uniqueIPs.add(ipAddr);
                }
         }
         // return the size of uniqueIPs
         return uniqueIPs.size();
     }
     
     public void printAllHigherThanNum(int num){
         System.out.println("\nAll Log Entries with status code greater than "+num+" are:");
         for (LogEntry le : records){
             int status = le.getStatusCode();
             if (status > num){
                 System.out.println(le);
             }
         }
     }
     
     public ArrayList uniqueIPVisitsOnDay(String someday){
         ArrayList<String> ipVisits = new ArrayList<String>();
         for (LogEntry le : records){
             String date = le.getAccessTime().toString();
             String currIP = le.getIpAddress();
             if (date.contains(someday) && !ipVisits.contains(currIP)){
                 ipVisits.add(currIP);
             }
         }
         return ipVisits;
     }
     
     public int countUniqueIPsInRange(int low, int high){
        ArrayList<String> ipVisits = new ArrayList<String>();
        int numUnique = 0;
        for (LogEntry le : records){
            int status = le.getStatusCode();
            String currIP = le.getIpAddress();
            if (status >= low && status <= high && !ipVisits.contains(currIP)){
                numUnique ++;
                ipVisits.add(currIP);
            }
        }
        return numUnique;
     }
     
     public HashMap<String,Integer> countVisitsPerIp(){
         HashMap<String,Integer> counts = new HashMap<String,Integer>();
         for (LogEntry le : records){
             String ip = le.getIpAddress();
             if(!counts.containsKey(ip)){
                 counts.put(ip, 1);
             } else {
                 counts.put(ip, counts.get(ip)+1);
             }
         }
         return counts;
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
}
