
/**
 * Write a description of class Tester here.
 * 
 * @author yamatokataoka
 * @version October 30th, 2019
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // creates a LogAnalyzer object
        LogAnalyzer la = new LogAnalyzer();
        // calls readFile on the data file short-test_log
        la.readFile("short-test_log");
        // calls printAll to print all the web logs.
        la.printAll();
    }
    
    // write the void method testUniqueIP that has no parameters.
    public void testUniqueIP () {
        // create a LogAnalyzer
        LogAnalyzer la = new LogAnalyzer();
        // read from the file short-test_log
        // la.readFile("short-test_log");
        // Q4: Run the method countUniqueIPs on the file weblog2_log.
        la.readFile("weblog2_log");
        // test the method countUniqueIPs.
        System.out.println("There is " + la.countUniqueIPs() + " IPs");
    }
    
    // test for printAllHigherThanNum
    public void testPrintAllHigherThanNum () {
        // create a LogAnalyzer
        LogAnalyzer la = new LogAnalyzer();
        // read from the file short-test_log
        // la.readFile("short-test_log");
        // test the method printAllHigherThanNum.
        // la.printAllHigherThanNum(200);
        // Q2: Run the method printAllHigherThanNum(400) on the file weblog1_log.
        la.readFile("weblog1_log");
        la.printAllHigherThanNum(400);
    }
    
    // test for uniqueIPVisitsOnDay
    public void testUniqueIPVisitsOnDay () {
        // create a LogAnalyzer
        LogAnalyzer la = new LogAnalyzer();
        // read from the file short-test_log
        // la.readFile("weblog-short_log");
        String date = "Sep 30";
        // System.out.println("Date is " + date);
        ArrayList<String> list = la.uniqueIPVisitsOnDay(date);
        for (String s : list) {
            // System.out.println(s);
        }
        // System.out.println("\n");
        // date = "Sep 14";
        // System.out.println("Date is " + date);
        // list = la.uniqueIPVisitsOnDay(date);
        for (String s : list) {
            // System.out.println(s);
        }
        
        // Q3: Run the method uniqueIPVisitsOnDay(“Mar 17”) on the file weblog1_log.
        // la.readFile("weblog1_log");
        // date = "Mar 24";
        // list = la.uniqueIPVisitsOnDay(date);
        // System.out.println(list.size());
        
        // Q5: Run the method uniqueIPVisitsOnDay(“Sep 27”) on the file weblog2_log.
        la.readFile("weblog2_log");
        date = "Sep 27";
        list = la.uniqueIPVisitsOnDay(date);
        System.out.println(list.size());
    }
    
    // test for countUniqueIPsInRange
    public void testCountUniqueIPsInRange () {
        // create a LogAnalyzer
        LogAnalyzer la = new LogAnalyzer();
        // read from the file short-test_log
        // la.readFile("short-test_log");
        int low = 200;
        int high = 299;
        // System.out.println("There is " + la.countUniqueIPsInRange(low, high)
        //                     + " IPs");
        // low = 300;
        // high = 399;
        // System.out.println("There is " + la.countUniqueIPsInRange(low, high)
        //                     + " IPs");
        // Run the method countUniqueIPsInRange(300,399) on the file weblog1_log.
        // la.readFile("weblog1_log");
        // low = 300;
        // high = 399;
        // System.out.println("There is " + la.countUniqueIPsInRange(low, high)
        //                     + " IPs");
        // Q6: Run the method countUniqueIPsInRange(400,499) on the file weblog2_log.
        la.readFile("weblog2_log");
        low = 400;
        high = 499;
        System.out.println("There is " + la.countUniqueIPsInRange(low, high)
                            + " IPs");
    }
    
    // test for countVisitsPerIP
    public void testCountVisitsPerIP () {
        // create a LogAnalyzer
        LogAnalyzer la = new LogAnalyzer();
        // read from the file short-test_log
        la.readFile("short-test_log");
        System.out.println(la.countVisitsPerIP());
    }
    
    // test for mostNumberVisitsByIP
    public void testMostNumberVisitsByIP () {
        // create a LogAnalyzer
        LogAnalyzer la = new LogAnalyzer();
        // read from the file short-test_log
        // la.readFile("weblog3-short_log");
        // Q1: Run the method mostNumberVisitsByIP after a HashMap has been created from the method countVisitsPerIP on the file weblog1_log.
        // la.readFile("weblog1_log");
        // HashMap<String, Integer> countVisitsPerIP = la.countVisitsPerIP();
        // System.out.println("mostNumberVisitsByIP: "
        //                 + la.mostNumberVisitsByIP(countVisitsPerIP));
        // Q7: Run the method mostNumberVisitsByIP after a HashMap has been created from the method countVisitsPerIP on the file weblog2_log.
        la.readFile("weblog2_log");
        HashMap<String, Integer> countVisitsPerIP = la.countVisitsPerIP();
        System.out.println("mostNumberVisitsByIP: "
                        + la.mostNumberVisitsByIP(countVisitsPerIP));
    }
    
    // test for iPsMostVisits
    public void testIPsMostVisits () {
        // create a LogAnalyzer
        LogAnalyzer la = new LogAnalyzer();
        // read from the file short-test_log
        // la.readFile("weblog3-short_log");
        // Q2: Run the method iPsMostVisits after a HashMap has been created from the method countVisitsPerIP on the file weblog1_log.
        // la.readFile("weblog1_log");
        // HashMap<String, Integer> countVisitsPerIP = la.countVisitsPerIP();
        // System.out.println(la.iPsMostVisits(countVisitsPerIP));
        // Q8: Run the method iPsMostVisits after a HashMap has been created from the method countVisitsPerIP on the file weblog2_log.
        la.readFile("weblog2_log");
        HashMap<String, Integer> countVisitsPerIP = la.countVisitsPerIP();
        System.out.println(la.iPsMostVisits(countVisitsPerIP));
    }
    
    // test for iPsForDays
    public void testIPsForDays () {
        // create a LogAnalyzer
        LogAnalyzer la = new LogAnalyzer();
        // read from the file short-test_log
        la.readFile("weblog3-short_log");
        System.out.println(la.iPsForDays());
    }
    
    // test for dayWithMostIPVisits
    public void testDayWithMostIPVisits () {
        // create a LogAnalyzer
        LogAnalyzer la = new LogAnalyzer();
        // read from the file short-test_log
        // la.readFile("weblog3-short_log");
        // Q3: Run the method dayWithMostIPVisits with a HashMap has been created from the method iPsForDays on the file weblog1_log.
        // la.readFile("weblog1_log");
        // HashMap<String, ArrayList<String>> iPsForDays = la.iPsForDays();
        // System.out.println(la.dayWithMostIPVisits(iPsForDays));
        // Q9: Run the method dayWithMostIPVisits with a HashMap has been created from the method iPsForDays on the file weblog2_log.
        la.readFile("weblog2_log");
        HashMap<String, ArrayList<String>> iPsForDays = la.iPsForDays();
        System.out.println(la.dayWithMostIPVisits(iPsForDays));
    }
    
    // test for iPsWithMostVisitsOnDay
    public void testIPsWithMostVisitsOnDay () {
        // create a LogAnalyzer
        LogAnalyzer la = new LogAnalyzer();
        // read from the file short-test_log
        // la.readFile("weblog3-short_log");
        // Q4: Run the method iPsWithMostVisitsOnDay with two parameters—one, a HashMap that has been created from the method iPsForDays on the file weblog1_log and two, the day “Mar 17”.
        // la.readFile("weblog1_log");
        // HashMap<String, ArrayList<String>> iPsForDays = la.iPsForDays();
        // System.out.println(la.iPsWithMostVisitsOnDay(iPsForDays, "Sep 30"));
        // System.out.println(la.iPsWithMostVisitsOnDay(iPsForDays, "Mar 17"));
        // Q10: Run the method iPsWithMostVisitsOnDay with two parameters—one, a HashMap that has been created from the method iPsForDays on the file weblog2_log and two, the day “Sep 30”.
        la.readFile("weblog2_log");
        HashMap<String, ArrayList<String>> iPsForDays = la.iPsForDays();
        System.out.println(la.iPsWithMostVisitsOnDay(iPsForDays, "Sep 30"));
    }
}
