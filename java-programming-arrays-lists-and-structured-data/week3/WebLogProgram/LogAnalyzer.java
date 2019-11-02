
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
     }
        
     public void readFile(String filename) {
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
