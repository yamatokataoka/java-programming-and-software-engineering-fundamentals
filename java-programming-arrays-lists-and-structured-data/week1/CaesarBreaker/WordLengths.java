
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
        for (int k = 0; k < counts.length; k++) {
            System.out.println(counts[k] + " words of length " + k);
        }
    }
    
    // Write a void method testCountWordLengths that creates a FileResource
    // so you can select a file, and creates a counts integer array of size 31.
    // This method should call countWordLengths with a file and then print
    // the number of words of each length.
    public void testCountWordLengths () {
        FileResource resource = new FileResource();
        int[] counts = new int[31];
        countWordLengths(resource, counts);
    }
}
