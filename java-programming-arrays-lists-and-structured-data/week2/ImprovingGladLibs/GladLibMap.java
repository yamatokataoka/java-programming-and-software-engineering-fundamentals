import edu.duke.*;
import java.util.*;

public class GladLibMap {
    // Replace the ArrayLists for adjectiveList, nounList, colorList,
    // countryList, nameList, animalList, timeList, verbList, and fruitList
    // with one HashMap myMap that maps a String representing a category
    // to an ArrayList of words in that category.
    private HashMap<String, ArrayList<String>> myMap;
    
    // declare an additional private ArrayList to keep track of
    // words that have been seen.
    private ArrayList<String> usedWordList;
    
    private ArrayList<String> usedCategoryList;
    
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    // Create the new HashMap in the constructors.
    public GladLibMap(){
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLibMap(String source){
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        // Modify the method initializeFromSource to create an Array of
        // categories and then iterate over this Array.
        String[] labels = {"country", "noun", "animal", "adjective",
                            "name", "color", "timeframe", "verb", "fruit"};
        // For each category
        for (String s : labels) {
            ArrayList <String> list = readIt(source + "/" + s + ".txt");
            myMap.put(s, list);
        }
        // read in the words from the associated file,
        // create an ArrayList of the words (using the method readIt),
        // and put the category and ArrayList into the HashMap.
        
        // initialize usedWordList
        usedWordList = new ArrayList<String>();
        usedCategoryList = new ArrayList<String>();
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        // Modify the method getSubstitute to replace all the if statements
        // that use category labels with one call to randomFrom that passes
        // the appropriate ArrayList from myMap.
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        else {
            if (usedCategoryList.indexOf(label) == -1) {
                usedCategoryList.add(label);
            }
            return randomFrom(myMap.get(label));
        }
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = "";
        // Once it finds a word to use, check to see if that word has been used
        // before or not.
        do {
            sub = getSubstitute(w.substring(first+1,last));
        } while (usedWordList.indexOf(sub) != -1);
        usedWordList.add(sub);
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    // Write a new method named totalWordsInMap with no parameters.
    // This method returns the total number of words in all the ArrayLists
    // in the HashMap.
    private int totalWordsInMap () {
        int totalWordsInMap = 0;
        for (ArrayList<String> arrayList : myMap.values()) {
            totalWordsInMap += arrayList.size();
        }
        return totalWordsInMap;
    }
    
    // Write a new method named totalWordsConsidered with no parameters.
    // This method returns the total number of words in the ArrayLists of
    // the categories that were used for a particular GladLib
    private int totalWordsConsidered () {
        int totalWordsConsidered = 0;
        for (String s : usedCategoryList) {
            totalWordsConsidered += myMap.get(s).size();
        }
        return totalWordsConsidered;
    }
    
    public void makeStory(){
        // clear out this new ArrayList
        usedWordList.clear();
        System.out.println("\n");
        // change to read in the template file madtemplate2.txt
        String story = fromTemplate("datalong/madtemplate2.txt");
        printOut(story, 60);
        // print out the total number of words that were replaced right after
        // the story is printed.
        System.out.println("\n\ntotal number of words that were replaced: "
                + usedWordList.size());
        // After printing the GladLib, call totalWordsInMap method and print
        // out the total number of words that were possible to pick from.
        System.out.println("total number of words in the HashMap: "
                + totalWordsInMap());
        System.out.println("total number of words in the ArrayLists of the categories that were used: "
                + totalWordsConsidered());
    }
}
