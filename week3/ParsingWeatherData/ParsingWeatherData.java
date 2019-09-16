
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

    // Write a method named lowestHumidityInFile that has one parameter, a CSVParser 
    // named parser. This method returns the CSVRecord that has the lowest humidity. 
    // If there is a tie, then return the first such record that was found.
    private CSVRecord lowestHumidityInFile (CSVParser parser) {
        CSVRecord lowestHumidityRecord = null;
        for (CSVRecord currentRecord : parser) {
            if (currentRecord.get("Humidity") != "N/A") {
                if (lowestHumidityRecord == null) {
                    lowestHumidityRecord = currentRecord;
                }
                else {
                    double lowest = Double.parseDouble(lowestHumidityRecord.get("Humidity"));
                    double current = Double.parseDouble(currentRecord.get("Humidity"));

                    if (lowest > current) {
                        lowestHumidityRecord = currentRecord;
                    }
                }
            }
        }
        return lowestHumidityRecord;
    }

    // Write the method lowestHumidityInManyFiles that has no parameters. This method returns
    // a CSVRecord that has the lowest humidity over all the files.
    private CSVRecord lowestHumidityInManyFiles () {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestHumidityRecord = null;
        String coldestDay = "";
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRecord = lowestHumidityInFile(fr.getCSVParser());
            if (currentRecord.get("Humidity") != "N/A") {
                if (lowestHumidityRecord == null) {
                    lowestHumidityRecord = currentRecord;
                }
                else {
                    double lowest = Double.parseDouble(lowestHumidityRecord.get("Humidity"));
                    double current = Double.parseDouble(currentRecord.get("Humidity"));

                    if (lowest > current) {
                        lowestHumidityRecord = currentRecord;
                    }
                }
            }
        }
        return lowestHumidityRecord;
    }

    // Write the method averageTemperatureInFile that has one parameter, 
    // a CSVParser named parser.
    // This method returns a double that represents the average temperature in the file. 
    private double averageTemperatureInFile (CSVParser parser) {
        double totalTemp = 0.0;
        int totalNum = 0;
        for (CSVRecord currentRecord : parser) {
            double currentTemp = Double.parseDouble(currentRecord.get("TemperatureF"));

            if (currentTemp != -9999) {
                totalTemp += currentTemp;
                totalNum++;
            }
        }
        return totalTemp / totalNum;
    }

    // Write the method averageTemperatureWithHighHumidityInFile that has two parameters, 
    // a CSVParser named parser and an integer named value.
    // This method returns a double that represents the average temperature of only those 
    // temperatures when the humidity was greater than or equal to value.
    private double averageTemperatureWithHighHumidityInFile (CSVParser parser, int value) {
        double averageTempWithHumidity = 0.0;
        double totalTemp = 0.0;
        int totalNum = 0;
        for (CSVRecord currentRecord : parser) {
            if (currentRecord.get("Humidity") != "N/A") {
                double currentTemp = Double.parseDouble(currentRecord.get("TemperatureF"));
                double currentHumidity = Double.parseDouble(currentRecord.get("Humidity"));

                if (currentHumidity >= value && currentTemp != -9999) {
                    totalTemp += currentTemp;
                    totalNum++;
                }
            }
        }
        if (totalTemp == 0) {
            return -9999.0;
        }
        return totalTemp / totalNum;
    }

    // You should also write a void method named testColdestHourInFile() to 
    // test this method and print out information
    public void testColdestHourInFile () {
        // weather-2015-01-01.csv
        FileResource fr = new FileResource("nc_weather/2015/weather-2015-01-01.csv");
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + coldest.get("TemperatureF") +
                            " at " + coldest.get("DateUTC"));

        // weather-2015-01-02.csv
        fr = new FileResource("nc_weather/2015/weather-2015-01-02.csv");
        coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + coldest.get("TemperatureF") +
                            " at " + coldest.get("DateUTC"));
    }

    // You should also write a void method named testFileWithColdestTemperature() 
    // to test coldestHourInFile method.
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

    // You should also write a void method named testLowestHumidityInFile() to test 
    // this method
    public void testLowestHumidityInFile () {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestHumidityRecord = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + lowestHumidityRecord.get("Humidity") +
                            " at " + lowestHumidityRecord.get("DateUTC"));
    }

    // You should also write a void method named testLowestHumidityInManyFiles() 
    // to test lowestHumidityInManyFiles method
    public void testLowestHumidityInManyFiles () {
        CSVRecord lowestHumidityDay = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + lowestHumidityDay.get("Humidity") +
                            " at " + lowestHumidityDay.get("DateUTC"));
    }

    // You should also write a void method named testAverageTemperatureInFile() 
    // to test averageTemperatureInFile method.
    public void testAverageTemperatureInFile () {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double averageTemperature = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is " + averageTemperature);
    }

    // You should also write a void method named
    // testAverageTemperatureWithHighHumidityInFile() to test
    // averageTemperatureWithHighHumidityInFile method.
    public void testAverageTemperatureWithHighHumidityInFile () {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        int valueOfHumidity = 80;
        double averageTemperature = averageTemperatureWithHighHumidityInFile(parser, valueOfHumidity);
        if (averageTemperature == -9999.0) {
            System.out.println("No temperatures with that humidity");
        }
        else {
            System.out.println("Average Temp when high Humidity is " + averageTemperature);
        }
    }
}
