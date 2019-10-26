
/**
 * Write a description of WordsInFiles here.
 * 
 * @author yamatokataoka
 * @version October 22nd, 2019
 */

import java.util.*;
import java.io.File;
import edu.duke.*;

// Create a new class called WordsInFiles.
public class WordsInFiles {
    // Create a private variable to store a HashMap that maps a word to
    // an ArrayList of filenames.
    private HashMap<String, ArrayList<String>> wordsInFilesMap;
    
    // Write a constructor to initialize the HashMap variable.
    public WordsInFiles () {
        wordsInFilesMap = new HashMap<String, ArrayList<String>>();
    }
    
    // Write a private void method named addWordsFromFile that has
    // one parameter f of type File.
    // This method should add all the words from f into the map.
    private void addWordsFromFile (File f) {
        FileResource fr = new FileResource(f);
        for (String word : fr.words()) {
            // If a word is already in the map,
            if (wordsInFilesMap.containsKey(word)) {
                // then add the current filename to its ArrayList
                // unless the filename is already in the ArrayList.
                int index = wordsInFilesMap.get(word).indexOf(f.getName());
                if (index == -1) {
                    wordsInFilesMap.get(word).add(f.getName());
                }
            }
            // If a word is not in the map, then you must create a
            // new ArrayList of type String with this word
            // and have the word map to this ArrayList.
            else {
                wordsInFilesMap.put(word, new ArrayList<String>());
                wordsInFilesMap.get(word).add(f.getName());
            }
        }
    }
    
    // Write a void method named buildWordFileMap that has no parameters.
    private void buildWordFileMap () {
        // first clears the map
        wordsInFilesMap.clear();
        
        // then uses a DirectoryResource to select a group of files.
        DirectoryResource dr = new DirectoryResource();
        
        // For each file,
        for (File f : dr.selectedFiles()) {
            // it puts all of its words into the map by calling the method
            // addWordsFromFile.
            addWordsFromFile(f);
        }
    }
    
    // Write the method maxNumber that has no parameters.
    // This method returns the maximum number of files any word appears in,
    // considering all words from a group of files.
    private int maxNumber () {
        int maxNumber = 0;
        for (ArrayList<String> als : wordsInFilesMap.values()) {
            if (als.size() > maxNumber) {
                maxNumber = als.size();
            }
        }
        return maxNumber;
    }
    
    // Write the method wordsInNumFiles that has one integer parameter
    // called number.
    // This method returns an ArrayList of words that appear in exactly
    // number files.
    private ArrayList<String> wordsInNumFiles (int number) {
        ArrayList<String> wordsInNumFiles = new ArrayList<String>();
        for (String s : wordsInFilesMap.keySet()) {
            if (wordsInFilesMap.get(s).size() == number) {
                wordsInNumFiles.add(s);
            }
        }
        return wordsInNumFiles;
    }
}
