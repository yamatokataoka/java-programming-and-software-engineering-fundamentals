
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
    
    // write the void method printAllHigherThanNum that has
    // one integer parameter num.
    public void printAllHigherThanNum (int num) {
        // examine all the web log entries in records
        // print those LogEntrys that have a status code greater than num.
        for (LogEntry le: records) {
            int status = le.getStatusCode();
            if (status > num) {
                System.out.println(le);
            }
        }
    }
     
    // write the method uniqueIPVisitsOnDay that has one String parameter
    // named someday
    // it returns an ArrayList of Strings of unique IP addresses that had access
    // on the given day. 
    public ArrayList<String> uniqueIPVisitsOnDay (String someday) {
        ArrayList<String> uniqueIPVisitsOnDay = new ArrayList<String>();
        for (LogEntry le: records) {
            String date = le.getAccessTime().toString();
            String ipAddress = le.getIpAddress();
            if (date.contains(someday) && !uniqueIPVisitsOnDay.contains(ipAddress)) {
                uniqueIPVisitsOnDay.add(ipAddress);
            }
        }
        return uniqueIPVisitsOnDay;
    }
    
    // In the LogAnalyzer class, write the method countUniqueIPsInRange that
    // has two integer parameters named low and high.
    // This method returns the number of unique IP addresses
    public int countUniqueIPsInRange (int low, int high) {
        ArrayList<String> uniqueIPsInRange = new ArrayList<String>();
        for (LogEntry le: records) {
            int status = le.getStatusCode();
            String ipAddress = le.getIpAddress();
            if (status >= low && status <= high && !uniqueIPsInRange.contains(ipAddress)) {
                uniqueIPsInRange.add(ipAddress);
            }
        }
        return uniqueIPsInRange.size();
    }
}
