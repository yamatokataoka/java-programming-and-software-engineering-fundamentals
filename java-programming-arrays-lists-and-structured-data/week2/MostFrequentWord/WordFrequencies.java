
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
                int currentFreq = myFreqs.get(index);
                myFreqs.set(index, currentFreq+1);
            }
        }
    }
    
    // Write the method findIndexOfMax that has no parameters.
    // This method returns an int that is the index location of the largest
    // value in myFreqs. If there is a tie, then return the first such value.
    public int findIndexOfMax () {
        int largestValue = 0;
        int indexOfMax = 0;
        for (int value : myFreqs) {
            if (largestValue < value) {
                largestValue = value;
            }
        }
        indexOfMax = myFreqs.indexOf(largestValue);
        return indexOfMax;
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
            System.out.println(myFreqs.get(k) + " " + myWords.get(k));
        }
        // Add code to the tester method to determine and print the word
        // that occurs the most often in a selected file and how many times
        // it occurs.
        int indexOfMax = findIndexOfMax();
        System.out.println("The word that occurs most often and its count are: "
                        + myWords.get(indexOfMax) + " "
                        + myFreqs.get(indexOfMax));
    }
}
