
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    // Modify findSimpleGene to add two additional parameters, 
    // one named startCodon for the start codon 
    // and one named stopCodon for the stop codon.
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        // Convert dna to upper case
        String DNA = dna.toUpperCase();
        
        String result = "";
        // Replace “ATG” to startCodon
        int beginIndex = DNA.indexOf(startCodon);
        // If there is no “ATG”, return the empty string.
        if (beginIndex == -1) {
            return result;
        }
        // Replace “TAA” to stopCodon
        int endIndex = DNA.indexOf(stopCodon, beginIndex + 3);
        // if there is no such “TAA”, return the empty string.
        if (endIndex == -1) {
            return result;
        }
        // If the length of the substring between the “ATG” 
        // and “TAA” is a multiple of 3, 
        // then return the substring that starts with that “ATG” 
        // and ends with that “TAA”.
        if (((endIndex + 3) - beginIndex) % 3 == 0) {
            result = dna.substring(beginIndex, endIndex + 3);
            return result;
        }
        return result;
    }
    
    // Write the void method testSimpleGene that has no parameters.
    public void testSimpleGene() {
       // Define startCodon and stopCodon
       String startCodon = "ATG";
       String stopCodon = "TAA";
       // You should create five DNA strings.
       // DNA with no “ATG”
       String dna = "GGAATTA";
       // Print the DNA string.
       System.out.println("DNA strand is " + dna);
       // 
       String gene = findSimpleGene(dna, startCodon, stopCodon);
       // If a gene exists following our algorithm above, 
       // then print the gene, otherwise print the empty string
       System.out.println("Gene is " + gene);
       
       // DNA with no “TAA”
       dna = "AAATTATGGGAT";
       System.out.println("DNA strand is " + dna);
       gene = findSimpleGene(dna, startCodon, stopCodon);
       System.out.println("Gene is " + gene);
       
       // DNA with no “ATG” and “TAA”
       dna = "AAGTGATAAG";
       System.out.println("DNA strand is " + dna);
       gene = findSimpleGene(dna, startCodon, stopCodon);
       System.out.println("Gene is " + gene);
       
       // DNA with ATG, TAA and the substring between them 
       // is a multiple of 3 (a gene)
       dna = "AATGGATTAAGTATTAAAGGT";
       System.out.println("DNA strand is " + dna);
       gene = findSimpleGene(dna, startCodon, stopCodon);
       System.out.println("Gene is " + gene);
       
       // DNA with ATG, TAA and the substring between them 
       // is not a multiple of 3
       dna = "AATGGATTATATTAAAGGT";
       System.out.println("DNA strand is " + dna);
       gene = findSimpleGene(dna, startCodon, stopCodon);
       System.out.println("Gene is " + gene);
       
       // DNA with lowercase letters
       dna = "aatggattaagtaaa";
       System.out.println("DNA strand is " + dna);
       gene = findSimpleGene(dna, startCodon, stopCodon);
       System.out.println("Gene is " + gene);
    }
}
