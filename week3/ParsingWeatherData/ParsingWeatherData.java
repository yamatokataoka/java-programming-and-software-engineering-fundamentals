
/**
 * Write a description of ParsingWeatherData here.
 * 
 * @author yamatokataoka
 * @version September 15th, 2019
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class ParsingWeatherData {
    // Write a method named coldestHourInFile that has one parameter, 
    // a CSVParser named parser. This method returns the CSVRecord with 
    // the coldest temperature in the file
    private CSVRecord coldestHourInFile (CSVParser parser) {
        CSVRecord coldestSoFar = null;
        for (CSVRecord currentRow : parser) {
            if (coldestSoFar == null) {
                coldestSoFar = currentRow;
            }
            else {
                double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                
                if (coldestTemp > currentTemp && currentTemp != -9999) {
                    coldestSoFar = currentRow;
                }
            }
        }
        return coldestSoFar;
    }
    
    // You should also write a void method named testColdestHourInFile() to 
    // test this method and print out information
    public void testColdestHourInFile () {
        // weather-2015-01-01.csv
        FileResource fr = new FileResource("nc_weather/2015/weather-2015-01-01.csv");
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + coldest.get("TemperatureF") +
                            " at " + coldest.get("TimeEST"));
        
        // weather-2015-01-02.csv
        fr = new FileResource("nc_weather/2015/weather-2015-01-02.csv");
        coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + coldest.get("TemperatureF") +
                            " at " + coldest.get("TimeEST"));
    }
}
