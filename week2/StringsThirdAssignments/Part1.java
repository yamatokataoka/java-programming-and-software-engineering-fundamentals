
/**
 * Write a description of Part1 here.
 * 
 * @author yamatokataoka
 * @version 09/08/2019
 */

import edu.duke.StorageResource;

public class Part1 {
    // Write the method findStopCodon that has three parameters, 
    // a String parameter named dna, an integer parameter named startIndex 
    // that represents where the first occurrence of ATG occurs in dna, 
    // and a String parameter named stopCodon.
    // This method returns the index of the first occurrence of stopCodon 
    // that appears past startIndex and is a multiple of 3 away from startIndex. 
    // If there is no such stopCodon, this method returns the length of the 
    // dna strand.
    private int findStopCodon(String dna, int startIndex, String stopCodon) {
        // find index that appers stopCodon from startIndex+3, currentIndex
        int currentIndex = dna.indexOf(stopCodon, startIndex + 3);
        // as long as currrentIndex is not equal to -1
        while (currentIndex != -1) {
            // check the length of like gene is a multple of 3
            int diff = currentIndex - startIndex;
            if (diff % 3 == 0) {
                return currentIndex;
            }
            else {
                currentIndex = dna.indexOf(stopCodon, currentIndex + 1);
            }
        }
        return dna.length();
    }
    
    // Write the method findGene that has one String parameter dna, 
    // representing a string of DNA.
    private String findGene(String dna, int startWhere) {
        // Find the index of the first occurrence of the start codon “ATG”. 
        // If there is no “ATG”, return the empty string
        int startIndex = dna.indexOf("ATG", startWhere);
        if (startIndex == -1) {
            return "";
        }
        // Find the index of the first occurrence of the stop codon “TAA” 
        // /"TGA"/"TAG"after the first occurrence of “ATG” that is 
        // a multiple of three away from the “ATG”. Hint: call findStopCodon.
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int minIndex = Math.min(Math.min(taaIndex, tgaIndex), tagIndex);
        if (minIndex == dna.length()) {
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }
    
    // Write the void method printAllGenes that has one String parameter dna, 
    // representing a string of DNA.
    public void printAllGenes(String dna) {
        // In this method you should repeatedly find genes and 
        // print each one until there are no more genes. 
        // Hint: remember you learned a while(true) loop and break.
        // Set startIndex to 0
        int startIndex = 0;
        while (true) {
            // find gene after startIndex
            String currentGene = findGene(dna, startIndex);
            // if gene is not fonud, break
            if (currentGene.isEmpty()) {
                break;
            }
            // print out gene
            System.out.println("gene is " + currentGene);
            // set startIndex to just past the end of the gene
            startIndex = dna.indexOf(currentGene, startIndex) +
                                     currentGene.length();
        }
    }
    
    // Make a copy of the printAllGenes method called getAllGenes.
    public StorageResource getAllGenes(String dna) {
        // this method should create and return a StorageResource 
        // containing the genes found.
        StorageResource store = new StorageResource();
        // Set startIndex to 0
        int startIndex = 0;
        while (true) {
            // find gene after startIndex
            String currentGene = findGene(dna, startIndex);
            // if gene is not fonud, break
            if (currentGene.isEmpty()) {
                break;
            }
            store.add(currentGene);
            // set startIndex to just past the end of the gene
            startIndex = dna.indexOf(currentGene, startIndex) +
                                     currentGene.length();
        }
        return store;
    }
    
    // Write the void method testFindStopCodon
    public void testFindStopCodon() {
        // calls the method findStopCodon with several examples and 
        // prints out the results to check if findStopCodon is 
        // working correctly
        //            01234567890123456789012345
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int index = findStopCodon(dna, 0, "TAA");
        if (index != 9) System.out.println("error on 9");
        index = findStopCodon(dna, 9, "TAA");
        if (index != 21) System.out.println("error on 21");
        index = findStopCodon(dna, 1, "TAA");
        if (index != 26) System.out.println("error on 26");
        index = findStopCodon(dna, 0, "TAG");
        if (index != 26) System.out.println("error on 26 TAG");
        System.out.println("test finished");
    }
    
    // Write the void method testFindGene that has no parameters.
    public void testFindGene(){
        // DNA with no “ATG”
        String dna = "xxxyyyzzzTAA";
        // Print the DNA string.
        System.out.println("DNA is " + dna);
        // Calculate the gene by sending this DNA string as an argument 
        // to findGene. If a gene exists following our algorithm above, 
        // then print the gene, otherwise print the empty string.
        String gene = findGene(dna, 0);
        System.out.println("gene is " + gene);
        
        // DNA with “ATG” and one valid stop codon
        dna = "xxxATGxxxyyyzzzTAA";
        System.out.println("DNA is " + dna);
        gene = findGene(dna, 0);
        System.out.println("gene is " + gene);
        
        // DNA with “ATG” and multiple valid stop codons
        dna = "xxxATGxxxyyyzzTAAzTAGxxxyyyTGAzzz";
        System.out.println("DNA is " + dna);
        gene = findGene(dna, 0);
        System.out.println("gene is " + gene);
        
        // DNA with “ATG” and no valid stop codons
        dna = "xxxATGxxxyyyzzTAAxxTAGxyyyzzTGA";
        System.out.println("DNA is " + dna);
        gene = findGene(dna, 0);
        System.out.println("gene is " + gene);
    }
    
    // test for printAllGenes
    public void testOn(String dna) {
        System.out.println("Testing printAllGenes on " + dna);
        printAllGenes(dna);
    }
    
    public void test() {
        testOn("ATGxxxTAAxxxATGxxxyyyzzzTGAxxx");
        testOn("");
        testOn("ATGxxxyyyzzzTAGxxxyyyATGxxTAAxyyyzzzATGTAA");
    }
    
    // test for getAllGenes
    public void testOnGetAllGenes(String dna) {
        System.out.println("Testing printAllGenes on " + dna);
        StorageResource store = getAllGenes(dna);
        for (String g : store.data()) {
            System.out.println(g);
        }
    }
    
    public void testGetAllGenes() {
        testOnGetAllGenes("ATGxxxTAAxxxATGxxxyyyzzzTGAxxx");
        testOnGetAllGenes("");
        testOnGetAllGenes("ATGxxxyyyzzzTAGxxxyyyATGxxTAAxyyyzzzATGTAA");
        testOnGetAllGenes("ATGxxxyyyxxxyyyzzz");
    }
}