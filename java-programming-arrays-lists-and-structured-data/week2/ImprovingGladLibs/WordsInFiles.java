
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
    
    // Write the void method printFilesIn that has one String parameter
    // named word.
    // This method prints the names of the files this word appears in,
    // one filename per line.
    private void printFilesIn (String word) {
        for (String s : wordsInFilesMap.keySet()) {
            ArrayList<String> fileNamesOfWord = wordsInFilesMap.get(s);
            if (s.equals(word)) {
                for (String fileName : fileNamesOfWord) {
                    System.out.println(fileName);
                }
            }
        }
    }
    
    // Write the void method tester that has no parameters. 
    public void tester () {
        // call buildWordFileMap to select a group of files and build a
        // HashMap of words
        buildWordFileMap();
        
        // determine the maximum number of files any word is in
        int maxNumber = maxNumber();
        System.out.println("The greatest number of files a word appears in is "
                            + maxNumber);
        // determine all the words that are in the maximum number of files
        // and for each such word
        ArrayList<String> wordsInNumFiles = wordsInNumFiles(maxNumber);
        System.out.print("and there are "
                            + wordsInNumFiles.size()
                            + " such words: ");
        for (String s : wordsInNumFiles) {
            System.out.print(" \"" + s + "\" ");
        }
        System.out.print("\n");
        // print the filenames of the files it is in
        for (String s : wordsInNumFiles) {
            System.out.println(" \"" + s + "\" " + " appears in the files: ");
            printFilesIn(s);
            System.out.print("\n");
        }
        
        // (optional) print out the complete map, all the keys, and for
        // each key its ArrayList
        /* comment outed
        for (String s : wordsInFilesMap.keySet()) {
            System.out.println("Key: " + "\"" + s + "\" ");
            System.out.print("File Names: ");
            for (String fileName : wordsInFilesMap.get(s)) {
                System.out.print(" \"" + fileName + "\" ");
            }
            System.out.print("\n\n");
        } 
        */
    }
}
