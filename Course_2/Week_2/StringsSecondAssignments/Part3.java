
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
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
    
    public int countGenes(String dna){
        // Defining variables
        int startIndex = 0;
        int geneCount = 0;
        while (true) {
            // Find gene after start index
            String currGene = findGene(dna, startIndex);
            // If no gene was found, leave the loop
            if (currGene.isEmpty()){
                break;
            }
            //System.out.println("Found gene: " + currGene + " in DNA strand");
            // Update geneCount
            geneCount += 1;
            // Set startIndex to just past the currGene
            startIndex = currGene.length() + dna.indexOf(currGene, startIndex);                    
        }
        return geneCount;
    }
    
    public void testCountGenes(){
        // Case 1
        System.out.println("Case 1");
        String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGATCCTCTCCAAGTAGCCTA";
        System.out.println("DNA strand: "+dna);
        System.out.println("Counting genes in strand.......");
        int output = countGenes(dna);
        System.out.println("Found " + output + " genes in DNA strand");
        System.out.println();
        
        // Case 2
        System.out.println("Case 2");
        dna = "";
        System.out.println("DNA strand: "+dna);
        System.out.println("Counting genes in strand.......");
        output = countGenes(dna);
        System.out.println("Found " + output + " genes in DNA strand");
        System.out.println();
        
        // Case 3
        System.out.println("Case 2");
        dna = "ATGATCATAAGAAGATAATAGAGGGCCATGTAAATGTTCATGTAGTTATGCGCTGA";
        System.out.println("DNA strand: "+dna);
        System.out.println("Counting genes in strand.......");
        output = countGenes(dna);
        System.out.println("Found " + output + " genes in DNA strand");
        System.out.println();
    }
}
