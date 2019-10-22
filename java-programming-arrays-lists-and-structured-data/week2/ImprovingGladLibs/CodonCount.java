
/**
 * Write a description of CodonCount here.
 * 
 * @author yamatokataoka
 * @version October 21st, 2019
 */

import java.util.*;

public class CodonCount {
    private HashMap<String, Integer> dnaCodonCount;
    
    // Write a constructor to initialize the HashMap variable.
    public CodonCount () {
        dnaCodonCount = new HashMap<String, Integer>();
    }
    
    // Write a void method named buildCodonMap that has two parameters,
    // an int named start and a String named dna.
    public void buildCodonMap (int start, String dna) {
        // make sure map is empty
        dnaCodonCount.clear();
        
        // build a new map of codons mapped to their counts from the string dna
        for (int k = start; dna.length() > k+2; k += 3) {
            String codon = dna.substring(k, k+3);
            if (dnaCodonCount.containsKey(codon)) {
                dnaCodonCount.put(codon, dnaCodonCount.get(codon)+1);
            }
            else {
                dnaCodonCount.put(codon, 1);
            }
        }
    }
    
    // Write a method named getMostCommonCodon that has no parameters.
    // This method returns a String, the codon in a reading frame that
    // has the largest count.
    public String getMostCommonCodon () {
        int largest = 0;
        String largetKey = "";
        for (String s : dnaCodonCount.keySet()) {
            if (largest < dnaCodonCount.get(s)) {
                largest = dnaCodonCount.get(s);
                largetKey = s;
            }
        }
        return largetKey;
    }
    
    // Write a void method named printCodonCounts that has two int parameters,
    // start and end.
    public void printCodonCounts (int start, int end) {
        // prints all the codons in the HashMap along with their counts
        // if their count is between start and end, inclusive.
        for (String s : dnaCodonCount.keySet()) {
            if (start < dnaCodonCount.get(s) && dnaCodonCount.get(s) <= end) {
                System.out.println(s + "\t" + dnaCodonCount.get(s));
            }
        }
    }
}
