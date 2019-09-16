
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
    
    // Write the method fileWithColdestTemperature that has no parameters. This method 
    // should return a string that is the name of the file from selected files that 
    // has the coldest temperature.
    private String fileWithColdestTemperature () {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord coldestSoFar = null;
        String coldestDay = "";
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if (coldestSoFar == null) {
                coldestSoFar = currentRow;
            }
            else {
                double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                
                if (coldestTemp > currentTemp && currentTemp != -9999) {
                    coldestSoFar = currentRow;
                    coldestDay = f.toString();
                }
            }
        }
        return coldestDay;
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
    
    // You should also write a void method named testFileWithColdestTemperature() 
    // to test this method.
    public void testFileWithColdestTemperature () {
        String coldestDay = fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + coldestDay);
        FileResource fr = new FileResource(coldestDay);
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature on that day was " + coldest.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were:");
        for (CSVRecord current : fr.getCSVParser()) {
            System.out.println( current.get("DateUTC") + ": " + current.get("TemperatureF"));
        }
    }
}
