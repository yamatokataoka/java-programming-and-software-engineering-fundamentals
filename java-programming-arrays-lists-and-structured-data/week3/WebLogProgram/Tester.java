
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
        la.readFile("short-test_log");
        // test the method countUniqueIPs.
        System.out.println("There is " + la.countUniqueIPs() + " IPs");
    }
    
    // test for printAllHigherThanNum
    public void testPrintAllHigherThanNum () {
        // create a LogAnalyzer
        LogAnalyzer la = new LogAnalyzer();
        // read from the file short-test_log
        la.readFile("short-test_log");
        // test the method printAllHigherThanNum.
        la.printAllHigherThanNum(200);
    }
}
