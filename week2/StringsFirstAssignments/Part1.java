
/**
 * Write a description of Part1 here.
 * 
 * @author Yamato Kataoka
 * @version 08/25/2019
 */
public class Part1 {
    public String findSimpleGene(String dna) {
        String result = "";
        // Finds the index position of the start codon “ATG”.
        int beginIndex = dna.indexOf("ATG");
        // If there is no “ATG”, return the empty string.
        if (beginIndex == -1) {
            return result;
        }
        // Finds the index position of the first stop codon “TAA” 
        // appearing after the “ATG” that was found.
        int endIndex = dna.indexOf("TAA", beginIndex + 3);
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
       // You should create five DNA strings.
       // DNA with no “ATG”
       String dna = "GGAATTA";
       // Print the DNA string.
       System.out.println("DNA strand is " + dna);
       // See if there is a gene by calling findSimpleGene 
       // with this string as the parameter.
       String gene = findSimpleGene(dna);
       // If a gene exists following our algorithm above, 
       // then print the gene, otherwise print the empty string
       System.out.println("Gene is " + gene);
       
       // DNA with no “TAA”
       dna = "AAATTATGGGAT";
       System.out.println("DNA strand is " + dna);
       gene = findSimpleGene(dna);
       System.out.println("Gene is " + gene);
       
       // DNA with no “ATG” and “TAA”
       dna = "AAGTGATAAG";
       System.out.println("DNA strand is " + dna);
       gene = findSimpleGene(dna);
       System.out.println("Gene is " + gene);
       
       // DNA with ATG, TAA and the substring between them 
       // is a multiple of 3 (a gene)
       dna = "AATGGATTAAGTATTAAAGGT";
       System.out.println("DNA strand is " + dna);
       gene = findSimpleGene(dna);
       System.out.println("Gene is " + gene);
       
       // DNA with ATG, TAA and the substring between them 
       // is not a multiple of 3
       dna = "AATGGATTATATTAAAGGT";
       System.out.println("DNA strand is " + dna);
       gene = findSimpleGene(dna);
       System.out.println("Gene is " + gene);
       
       // test
       dna = "AAATGCCCTAACTAGATTAAGAAACC";
       System.out.println("DNA strand is " + dna);
       gene = findSimpleGene(dna);
       System.out.println("Gene is " + gene);
    }
}
