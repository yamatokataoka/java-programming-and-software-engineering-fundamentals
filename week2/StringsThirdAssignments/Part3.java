
/**
 * Write a description of Part3 here.
 * 
 * @author yamatokataoka
 * @version 09/08/2019
 */

import edu.duke.StorageResource;
import edu.duke.FileResource;

public class Part3 {
    // Write the void method processGenes that has one parameter sr, 
    // which is a StorageResource of strings. 
    // This method processes all the strings in sr to find out 
    // information about them.
    // * Modify your processGenes method so that it prints all the 
    // Strings that are longer than 60 characters
    private void processGenes (StorageResource sr) {
        int Count9C = 0;
        int countCG = 0;
        int longestGeneLength = 0;
        for (String gene : sr.data()) {
            // print all the Strings in sr that are 
            // longer than 9 characters
            if (gene.length() > 60) {
                System.out.println("String that are longer than 60 characters is " 
                                    + gene);
                Count9C++;
            }
            
            // print the Strings in sr whose C-G-ratio is 
            // higher than 0.35
            double cgRatio = cgRatio(gene);
            if (cgRatio > 0.35) {
                System.out.println("String that cgRatio are higher than 0.35 is "
                                    + gene);
                countCG++;
            }
            
            // print the length of the longest gene in sr
            if (longestGeneLength < gene.length()) {
                longestGeneLength = gene.length();
            }
        }
        // print the number of Strings in sr that are 
        // longer than 9 characters
        System.out.println("Number of string that are longer than 60 characters is "
                            + Count9C);
        
        // print the number of strings in sr whose C-G-ratio is 
        // higher than 0.35
        System.out.println("Number of string that are C-G-ratio is higher than 0.35 is "
                            + countCG);
        
        // print the length of the longest gene in sr
        System.out.println("Length of longest Gene is "
                            + longestGeneLength);
    }
    
    // Copied from Part2
    private double cgRatio(String dna) {
        double count = 0;
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
        double cgRatio = count / dna.length();
        return cgRatio;
    }
    
    // Write a method testProcessGenes. 
    // This method will call your processGenes method on different 
    // test cases.
    public void testProcessGenes() {
        // Call Part1 class
        Part1 part1 = new Part1();
        // one DNA string that has some genes 
        // longer than 9 characters
        String dna = "ATGxxxyyyTAAxxx";
        System.out.println("Testing dna is " + dna);
        StorageResource store = part1.getAllGenes(dna);
        processGenes(store);
        
        // one DNA string that has no genes longer 
        // than 9 characters
        dna = "ATGxxxyyyxxxyyyzzz";
        System.out.println("Testing dna is " + dna);
        store = part1.getAllGenes(dna);
        processGenes(store);
        
        // one DNA string that has some genes whose C-G-ratio 
        // is higher than 0.35
        dna = "ATGCCCGGGTAAxxx";
        System.out.println("Testing dna is " + dna);
        store = part1.getAllGenes(dna);
        processGenes(store);
        
        // one DNA string that has some genes whose C-G-ratio 
        // is lower than 0.35
        dna = "ATGxxxGGGTAAxxxATGxxxyyyTAG";
        System.out.println("Testing dna is " + dna);
        store = part1.getAllGenes(dna);
        processGenes(store);
    }
    
    // test testProcessGenes with real DNA
    // Modify the method testProcessGenes to call processGenes 
    // with a StorageResource of the genes found in the file 
    // brca1line.fa.
    public void testProcessGenesWithFile() {
        // Call Part1 class
        Part1 part1 = new Part1();
        // You can use a FileResource to open the file and the
        // FileResource method asString to convert the contents of
        // the file to a single string so that you can use it
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        dna = dna.toUpperCase();
        System.out.println("Testing dna is " + dna);
        StorageResource store = part1.getAllGenes(dna);
        processGenes(store);
    }
}
