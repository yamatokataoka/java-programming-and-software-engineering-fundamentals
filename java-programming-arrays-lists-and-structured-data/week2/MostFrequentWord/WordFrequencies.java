
/**
 * Write a description of WordFrequencies here.
 * 
 * @author yamatokataoka
 * @version October 17th, 2019
 */

import java.util.*;
import edu.duke.*;

// create a new class called WordFrequencies
public class WordFrequencies {
    // Create two private variables. One is called myWords and should be an
    // ArrayList of type String to store unique words from a file, and one is
    // called myFreqs and should be an ArrayList of type Integer.
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    // Write a constructor WordFrequencies, and initialize the private variables.
    public WordFrequencies () {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    // Write a void method findUnique that has no parameters.
    public void findUnique () {
        // first clear both myWords and myFreqs, using the .clear() method.
        myWords.clear();
        myFreqs.clear();

        // then it selects a file
        FileResource file = new FileResource();
        
        // then iterates over every word in the file
        for (String word : file.words()) {
            // change word to lower case
            word = word.toLowerCase();
            // putting the unique words found into myWords.
            int index = myWords.indexOf(word);
            if (index == -1) {
                myWords.add(word);
                // For each word in the kth position of myWords, it puts the count
                // of how many times that word occurs from the selected file into
                // the kth position of myFreqs
                myFreqs.add(1);
            }
            else {
                int occurFreq = myFreqs.get(index);
                myFreqs.set(index, occurFreq++);
            }
        }
    }
    
    // Write a void tester method that has no parameters.
    public void tester () {
        // call findUnique.
        findUnique();
        // Then print out the number of unique words
        int numUniqueWord = myWords.size();
        System.out.println("Number of unique words: " + numUniqueWord);
        // for each unique word, print the frequency of each word and the word
        for (int k=0; k<myWords.size(); k++) {
            System.out.println(myFreqs.get(k) + "¥t" + myWords.get(k));
        }
    }
}
