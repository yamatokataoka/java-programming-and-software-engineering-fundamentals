
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
    
    // write the method countVisitsPerIP, which has no parameters.
    // This method returns a HashMap<String, Integer>
    public HashMap<String, Integer> countVisitsPerIP () {
        HashMap<String, Integer> countVisitsPerIP = new HashMap<String, Integer>();
        for (LogEntry le: records) {
            String ip = le.getIpAddress();
            if (!countVisitsPerIP.containsKey(ip)) {
                countVisitsPerIP.put(ip, 1);
            }
            else {
                countVisitsPerIP.put(ip, countVisitsPerIP.get(ip) + 1);
            }
        }
        return countVisitsPerIP;
    }
    
    // write the method mostNumberVisitsByIP, which has one parameter,
    // a HashMap<String, Integer>
    // This method returns the maximum number of visits to this website
    // by a single IP address
    public int mostNumberVisitsByIP (HashMap<String, Integer> countVisitsPerIP) {
        int mostNumberVisitsByIP = 0;
        for (int num: countVisitsPerIP.values()) {
            if (num > mostNumberVisitsByIP) {
                mostNumberVisitsByIP = num;
            }
        }
        return mostNumberVisitsByIP;
    }
    
    // write the method iPsMostVisits, which has one parameter,
    // a HashMap<String, Integer>
    // This method returns an ArrayList of Strings of IP addresses that all
    // have the maximum number of visits to this website.
    public ArrayList<String> iPsMostVisits (HashMap<String, Integer> countVisitsPerIP) {
        ArrayList<String> iPsMostVisits = new ArrayList<String>();
        for (String ip: countVisitsPerIP.keySet()) {
            if (countVisitsPerIP.get(ip).equals(mostNumberVisitsByIP(countVisitsPerIP))) {
                iPsMostVisits.add(ip);
            }
        }
        return iPsMostVisits;
    }
    
    // write the method iPsForDays, which has no parameters.
    // This method returns a HashMap<String, ArrayList<String>>
    public HashMap<String, ArrayList<String>> iPsForDays () {
        HashMap<String, ArrayList<String>> iPsForDays = new HashMap<String, ArrayList<String>>();
        // uses records
        for (LogEntry le: records) {
            // maps days from web logs to an ArrayList of IP addresses that
            // occurred on that day (including repeated IP addresses).
            String date = le.getAccessTime().toString().substring(4,10);
            String ipAddress = le.getIpAddress();
            if (!iPsForDays.containsKey(date)) {
                ArrayList<String> iPsMostVisits = new ArrayList<String>();
                iPsMostVisits.add(ipAddress);
                iPsForDays.put(date, iPsMostVisits);
            }
            else {
                iPsForDays.get(date).add(ipAddress);
                iPsForDays.put(date, iPsForDays.get(date));
            }
        }
        return iPsForDays;
    }
    
    // the method dayWithMostIPVisits, which has one parameter
    // that is a HashMap<String, ArrayList<String>>
    public String dayWithMostIPVisits (HashMap<String, ArrayList<String>> iPsForDays) {
        String dayWithMostIPVisits = "";
        int maxNum = 0;
        for (String date: iPsForDays.keySet()) {
            if (iPsForDays.get(date).size() > maxNum) {
                dayWithMostIPVisits = date;
                maxNum = iPsForDays.get(date).size();
            }
        }
        // This method returns the day that has the most IP address visits.
        return dayWithMostIPVisits;
    }
    
    // the method iPsWithMostVisitsOnDay, which has two parameters—the first one
    // is a HashMap<String, ArrayList<String>>
    // and the second parameter is a String representing a day in the format “MMM DD”
    // This method returns an ArrayList<String> of IP addresses that had the most accesses on the given day
    public ArrayList<String> iPsWithMostVisitsOnDay (
            HashMap<String, ArrayList<String>> iPsForDays,
            String givenDate) {
        ArrayList<String> iPsForGivenDate= iPsForDays.get(givenDate);
        HashMap<String, Integer> countVisitsPerIP = new HashMap<String, Integer>();
        for (String ip: iPsForGivenDate) {
            if (!countVisitsPerIP.containsKey(ip)) {
                countVisitsPerIP.put(ip, 1);
            }
            else {
                countVisitsPerIP.put(ip, countVisitsPerIP.get(ip) + 1);
            }
        }
        return iPsMostVisits(countVisitsPerIP);
    }
}
