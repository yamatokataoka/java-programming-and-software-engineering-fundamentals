
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
        for (String s : fr.words()) {
            // If a word is already in the map,
            if (wordsInFilesMap.containsKey(s)) {
                // then add the current filename to its ArrayList
                int index = wordsInFilesMap.get(s).indexOf(f.getName());
                // unless the filename is already in the ArrayList.
                if (index != -1) {
                    wordsInFilesMap.get(s).add(f.getName());
                }
            }
            // If a word is not in the map, then you must create a
            // new ArrayList of type String with this word
            // and have the word map to this ArrayList.
            else {
                wordsInFilesMap.put(s, new ArrayList<String>());
                wordsInFilesMap.get(s).add(f.getName());
            }
        }
    }
}
