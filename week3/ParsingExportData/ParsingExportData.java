
/**
 * Write a description of ParsingExportData here.
 * 
 * @author yamatokataoka 
 * @version September 12th, 2019
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class ParsingExportData {
    // Write a method named tester that will create your CSVParser 
    // and call each of the methods below
    public void tester () {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        // reset the parser
        parser = fr.getCSVParser();
    }
    
    // Write a method named countryInfo that has two parameters, 
    // parser is a CSVParser and country is a String.
    // This method returns a string
    private String countryInfo (CSVParser parser, String country) {
        
        return "";
    }
}
