
/**
 * Write a description of BabyBirths here.
 * 
 * @author yamatokataoka
 * @version September 21st, 2019
 */

import edu.duke.*;
import org.apache.commons.csv.*;

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
    
    public void testTotalBirths () {
        FileResource fr = new FileResource("testing/yob2014short.csv");
        totalBirths(fr);
    }
}
