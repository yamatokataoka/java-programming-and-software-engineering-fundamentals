
/**
 * Write a description of WordLengths here.
 * 
 * @author yamatokataoka
 * @version October 12th, 2019
 */

import edu.duke.*;

public class WordLengths {
    // Write a void method countWordLengths that has two parameters, a
    // FileResource named resource and an integer array named counts.
    // This method should read in the words from resource and count
    // the number of words of each length for all the words in resource,
    // storing these counts in the array counts.
    public void countWordLengths (FileResource resource, int[] counts) {
        for (String word: resource.words()) {
            StringBuilder sb = new StringBuilder(word);
            int length = sb.length();
            if (!Character.isLetter(sb.charAt(0))) {
                sb.deleteCharAt(0);
            }
            else if (!Character.isLetter(sb.charAt(length - 1))) {
                sb.deleteCharAt(length - 1);
            }
            length = sb.length();
            if (length >= counts.length) {
                counts[counts.length - 1] += 1;
            }
            else {
                counts[length] += 1;
            }
        }
    }
    
    public void testCountWordLengths () {
        FileResource resource = new FileResource("ProgrammingBreakingCaesarData/smallHamlet.txt");
        int[] counts = new int[10];
        countWordLengths(resource, counts);
    }
}
