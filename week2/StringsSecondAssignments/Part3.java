
/**
 * Write a description of Part3 here.
 * 
 * @author Yamato
 * @version 2019/9/3
 */
public class Part3 {
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
    
    // Write the method named countGenes that has a String parameter named dna
    // representing a string of DNA. This method returns the number of 
    // genes found in dna.
    private int countGenes(String dna) {
        // Hint: This is very similar to finding all genes and printing them, 
        // except that instead of printing all the genes you will count them.
        int startIndex = 0;
        int count = 0;
        while (true) {
            // find gene after startIndex
            String currentGene = findGene(dna, startIndex);
            // if gene is not fonud, break
            if (currentGene.isEmpty()) {
                break;
            }
            // count up
            count++;
            // set startIndex to just past the end of the gene
            startIndex = dna.indexOf(currentGene, startIndex) +
                                     currentGene.length();
        }
        return count;
    }
    
    // Write the void method named testCountGenes that has no parameters.
    public void testCountGenes() {
        // This method calls countGenes with many example strings and 
        // prints the result for each.
        String dna = "ATGxxxTAAxxxATGxxxyyyzzzTGAxxx";
        System.out.println("Testing countGenes on " + dna);
        System.out.println("The number of genes is " + countGenes(dna));
        
        dna = "";
        System.out.println("Testing countGenes on " + dna);
        System.out.println("The number of genes is " + countGenes(dna));
        
        dna = "ATGxxxyyyzzzTAGxxxyyyATGxxTAAxyyyzzzATGTAA";
        System.out.println("Testing countGenes on " + dna);
        System.out.println("The number of genes is " + countGenes(dna));
    }
}
