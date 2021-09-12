
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        // This method returns the index of the first occurence of stopCodon taht
        //appears past startIndex and is a multiple of 3 away from startIndex.
        int stopIndex = dna.indexOf(stopCodon, startIndex+3);
        while ( stopIndex != -1){
            int geneLength = stopIndex - startIndex;
            if ( geneLength % 3 == 0){
                return stopIndex;
            } else { 
                stopIndex = dna.indexOf(stopCodon, stopIndex+1);
            }
        }
        return -1;
    }
    
    public String findGene(String dna, int where){
        // Get the index of the startCodon
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1){
            return "";
        }
        // Get indices of stopCodons which are multiples of 3 away from the startCodon
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        // Check for the minimum index of the three
        int minIndex = 0;
        if (taaIndex == -1 || tgaIndex != -1 && tgaIndex < taaIndex){
            minIndex = tgaIndex;
        } else {
            minIndex = taaIndex;
        }
        
        if (minIndex == -1 || tagIndex != -1 && tagIndex < minIndex){
            minIndex = tagIndex;
        }
        
        if (minIndex == -1){
            return "";
        }
        
        String result = dna.substring(startIndex, minIndex+3);
        return result;
    }
    
    public StorageResource getAllGenes(String dna){
        // Defining variables
        int startIndex = 0;
        StorageResource genes = new StorageResource();
        while (true) {
            // Find gene after start index
            String currGene = findGene(dna, startIndex);
            // If no gene was found, leave the loop
            if (currGene.isEmpty()){
                break;
            }
            //System.out.println("Found gene: " + currGene + " in DNA strand");
            // Update geneCount
            genes.add(currGene);
            // Set startIndex to just past the currGene
            startIndex = currGene.length() + dna.indexOf(currGene, startIndex);                    
        }
        return genes;
    }
    
    public void testOn(String testDNA){
        System.out.println("Testing getAllGenes on " + testDNA);
        StorageResource genes = getAllGenes(testDNA);
        for(String gene: genes.data()){
            System.out.println(gene);
        }
        System.out.println();
    }
    
    public void testFindAllGenes(){
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGATCCTCTCCAAGTAGCCTA");
        testOn("");
        testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAAATGTTCATGTAGTTATGCGCTGA");
    }
}
