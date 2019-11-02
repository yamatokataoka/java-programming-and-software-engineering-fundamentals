
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author yamatokataoka
 * @version October 30th, 2019
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete the constructor to initialize records to an empty ArrayList
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete the readFile method to create a FileResource
         FileResource fr = new FileResource(filename);
         // iterate over all the lines in the file.
         for (String s : fr.lines()) {
             // For each line, create a LogEntry and store it
             // in the records ArrayList.
             LogEntry le = WebLogParser.parseEntry(s);
             records.add(le);
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     // write the method countUniqueIPs that has no parameters.
     // This method should return an integer representing the number of
     // unique IP addresses.
     public int countUniqueIPs () {
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for (LogEntry le: records) {
             String ipAddress = le.getIpAddress();
             if (!uniqueIPs.contains(ipAddress)) {
                 uniqueIPs.add(ipAddress);
             }
         }
         return uniqueIPs.size();
     }
}
