
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
        
        // test countryInfo method
        String country = "Germany";
        System.out.println("Look info for " + country);
        System.out.println("The country info is " + countryInfo(parser, country));
        // reset the parser
        parser = fr.getCSVParser();
    }
    
    // Write a method named countryInfo that has two parameters, 
    // parser is a CSVParser and country is a String.
    // This method returns a string
    private String countryInfo (CSVParser parser, String country) {
        // for each row in CSV file
        for (CSVRecord record : parser) {
            String countryOfRow = record.get("Country");
            if (countryOfRow.equals(country)) {
                return countryOfRow + ": " + record.get("Exports")
                       + ": " + record.get("Value (dollars)");
            }
        }
        return "NOT FOUND";
    }
}
