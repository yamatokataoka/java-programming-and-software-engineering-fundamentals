
/**
 * Write a description of WordsInFiles here.
 * 
 * @author yamatokataoka
 * @version October 22nd, 2019
 */

import java.util.*;

// Create a new class called WordsInFiles.
public class WordsInFiles {
    // Create a private variable to store a HashMap that maps a word to
    // an ArrayList of filenames.
    private HashMap<String, ArrayList<String>> wordsInFilesMap;
    
    // Write a constructor to initialize the HashMap variable.
    public WordsInFiles () {
        wordsInFilesMap = new HashMap<String, ArrayList<String>>();
    }
}
