
/**
 * Write a description of Part2 here.
 * 
 * @author yamatokataoka
 * @version 09/08/2019
 */

import edu.duke.FileResource;

public class Part2 {
    // Write the method cgRatio that has one String parameter dna, 
    // and returns the ratio of C’s and G’s in dna as a fraction of 
    // the entire strand of DNA.
    private double cgRatio(String dna) {
        int count = 0;
        int startIndex = 0;
        int currentIndex = 0;
        String C = "C";
        String G = "G";
        while (true) {
            currentIndex = dna.indexOf(C, startIndex);
            if (currentIndex == -1) {
                break;
            }
            count++;
            startIndex = dna.indexOf(C, startIndex) + 1;
        }
        
        startIndex = 0;
        currentIndex = 0;
        while (true) {
            currentIndex = dna.indexOf(G, startIndex);
            if (currentIndex == -1) {
                break;
            }
            count++;
            startIndex = dna.indexOf(G, startIndex) + 1;
        }
        return ((double) count)/dna.length();
    }
    
    // Write a method countCTG that has one String parameter dna, 
    // and returns the number of times the codon CTG appears in dna.
    private int countCTG(String dna) {
        int count = 0;
        int startIndex = 0;
        String CTG = "CTG";
        while (true) {
            int currentIndex = dna.indexOf(CTG, startIndex);
            if (currentIndex == -1) {
                break;
            }
            count++;
            startIndex = dna.indexOf(CTG, startIndex) 
                         + CTG.length();
        }
        return count;
    }
    
    // test cgRation method
    public void testCGRatio() {
        String dna = "ATGCCATAG";
        System.out.println("Testing dna is " + dna);
        double cgRatio = cgRatio(dna);
        System.out.println("CGs ratio is " + cgRatio);
    }
    
    // test countCTG method
    public void testCountCTG() {
        String dna = "ATGCCATAG";
        System.out.println("Testing dna is " + dna);
        int countCTG = countCTG(dna);
        System.out.println("the number of CTG is " + countCTG);
        
        dna = "";
        System.out.println("Testing dna is " + dna);
        countCTG = countCTG(dna);
        System.out.println("the number of CTG is " + countCTG);
        
        dna = "ATGxxxCTGxxxyyyzzzCTG";
        System.out.println("Testing dna is " + dna);
        countCTG = countCTG(dna);
        System.out.println("the number of CTG is " + countCTG);
    }
    
    // String in Java quiz
    public void testCountCTGWithFile() {
        // Call Part1 class
        Part1 part1 = new Part1();
        // You can use a FileResource to open the file and the
        // FileResource method asString to convert the contents of
        // the file to a single string so that you can use it
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        dna = dna.toUpperCase();
        System.out.println("Testing dna is " + dna);
        int countCTG = countCTG(dna);
        System.out.println("the number of CTG is " + countCTG);
    }
}
