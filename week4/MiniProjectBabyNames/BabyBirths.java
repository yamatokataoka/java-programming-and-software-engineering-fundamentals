
/**
 * Write a description of BabyBirths here.
 * 
 * @author yamatokataoka
 * @version September 21st, 2019
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

// You will write a program with several methods and tester methods to test 
// each method you write.
public class BabyBirths {
    // Modify the method totalBirths (shown in the video for this project) to 
    // also print the number of girls names , the number of boys names and the 
    // total names in the file.
    private void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int totalNames = 0;
        int totalBoysNames = 0;
        int totalGirlsNames = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            totalNames++;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
                totalBoysNames++;
            }
            else {
                totalGirls += numBorn;
                totalGirlsNames++;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("total boys = " + totalBoys);
        System.out.println("total girls = " + totalGirls);
        System.out.println("total names = " + totalNames);
        System.out.println("total boys names = " + totalBoysNames);
        System.out.println("total girls names = " + totalGirlsNames);
    }
    
    // Write the method named getRank that has three parameters: an integer 
    // named year, a string named name, and a string named gender 
    // (F for female and M for male).
    // This method returns the rank of the name in the file for the given gender,
    // where rank 1 is the name with the largest number of births.
    private int getRank (String year, String name, String gender) {
        FileResource fr = new FileResource("us_babynames/us_babynames_test/yob" 
                                            + year + "short.csv");
        int rankInGender = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            // check gender with given gender
            if (rec.get(1).equals(gender)) {
                rankInGender++;
                if (rec.get(0).equals(name)) {
                    return rankInGender;
                }
            }
        }
        return -1;
    }
    
    // Write the method named getName that has three parameters: an integer 
    // named year, an integer named rank, and a string named gender 
    // (F for female and M for male).
    // This method returns the name of the person in the file at this rank, 
    // for the given gender
    // If the rank does not exist in the file, then “NO NAME” is returned.
    private String getName (String year, int rank, String gender) {
        FileResource fr = new FileResource("us_babynames/us_babynames_test/yob" 
                                            + year + "short.csv");
        int rankInGender = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            
            // check gender with given gender
            if (rec.get(1).equals(gender)) {
                rankInGender++;
                if (rankInGender == rank) {
                    return rec.get(0);
                }
            }
        }
        return "NO NAME";
    }
    
    // Write the void method named whatIsNameInYear that has four parameters: 
    // a string name, an integer named year representing the year that 
    // name was born, an integer named newYear and a string named gender
    // This method determines what name would have been named if they were 
    // born in a different year, based on the same popularity.
    private String whatIsNameInYear (String name, String year, String newYear
                                    , String gender) {
        int newRank = getRank(year, name, gender);
        String newName = getName(newYear, newRank, gender);
        return newName;
    }
    
    // Write the method yearOfHighestRank that has two parameters: a string name,
    // and a string named gender
    // This method selects a range of files to process and returns an integer, 
    // the year with the highest rank for the name and gender.
    // If the name and gender are not in any of the selected files,
    // it should return -1. 
    private int yearOfHighestRank (String name, String gender) {
        int highestRank = 0;
        int yearOfHighestRank = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            String filename = f.getName();
            String year = filename.substring(3,7);
            int currentRank = getRank(year, name, gender);
            if ((highestRank > currentRank || highestRank == 0) 
                                          && (currentRank != -1)) {
                highestRank = currentRank;
                yearOfHighestRank = Integer.parseInt(year);
            }
        }

        if (highestRank == 0) {
            return -1;
        }
        return yearOfHighestRank;
    }
    
    // test totalBirths
    public void testTotalBirths () {
        FileResource fr = new FileResource("us_babynames/us_babynames_test/yob2014short.csv");
        totalBirths(fr);
    }
    
    // test getRank
    public void testGetRank () {
        String year = "2014";
        String name = "Avalon";
        String gender = "F";
        int rank = getRank(year, name, gender);
        System.out.println("Search with " + name + ", gender is " + gender
                            + " in " + year);
        System.out.println("rank = " + rank);
    }
    
    // test getName
    public void testGetName () {
        String year = "2012";
        int rank = 160;
        String gender = "F";
        String name = getName(year, rank, gender);
        System.out.println("Search at " + rank + " rank, gender is " + gender
                            + " in " + year);
        System.out.println("name = " + name);
    }
    
    // test whatIsNameInYear
    public void testWhatIsNameInYear () {
        String name = "Isabella";
        String year = "2012";
        String newYear = "2014";
        String gender = "F";
        String newName = whatIsNameInYear(name ,year, newYear, gender);
        System.out.println(name + " born in " + year + " would be " + newName
                            + " if she was born in " + newYear);
    }
    
    // test yearOfHighestRank
    public void testYearOfHighestRank () {
        String name = "Olivia";
        String gender = "F";
        int yearOfHighestRank = yearOfHighestRank(name, gender);
        System.out.println("name is " + name);
        System.out.println("gender is " + gender);
        System.out.println("year of highest ranking is " + yearOfHighestRank);
        
        // the case there is no name
        name = "noName";
        gender = "F";
        yearOfHighestRank = yearOfHighestRank(name, gender);
        System.out.println("name is " + name);
        System.out.println("gender is " + gender);
        System.out.println("year of highest ranking is " + yearOfHighestRank);
    }
}
