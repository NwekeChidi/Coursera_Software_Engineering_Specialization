
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
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
}
