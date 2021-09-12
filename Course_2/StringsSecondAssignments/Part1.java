
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
    
    
    public void testFindStopCodon (){
        // Case 1
        System.out.println("Case1: stopCodon = TAA");
        //                vvv         vvv
        String dna = "AATCATGCCTGTAAGGTAAGCCATC";
        String stopCodon = "TAA";
        int startIndex = dna.indexOf("ATG");
        int output = findStopCodon(dna, startIndex, stopCodon);
        if (output != 16){
            System.out.println("Error: " + output + " instead of 16");
        } else {
            System.out.println("test passed");
        }
        
        // Case 2
        System.out.println("Case2: stopCodon = TAG");
        //         vvv         vvv
        dna = "AATCATGCCTGTAAGGTAGGCCATC";
        stopCodon = "TAG";
        startIndex = dna.indexOf("ATG");
        output = findStopCodon(dna, startIndex, stopCodon);
        if (output != 16){
            System.out.println("Error: " + output + " instead of 16");
        } else {
            System.out.println("test passed");
        }
        
        // Case 3
        System.out.println("Case3: stopCodon = TGA");
        //         vvv            vvv
        dna = "AATCATGCCTGTAAGTCAATGAGCCATC";
        stopCodon = "TGA";
        startIndex = dna.indexOf("ATG");
        output = findStopCodon(dna, startIndex, stopCodon);
        if (output != 19){
            System.out.println("Error: " + output + " instead of 19");
        } else {
            System.out.println("test passed");
        }
        
        // Case 4
        System.out.println("Case4: stopCodon = TGA");
        //         vvv           
        dna = "AATCATGCCTGTAAGTCTGAGCCATC";
        stopCodon = "TGA";
        startIndex = dna.indexOf("ATG");
        output = findStopCodon(dna, startIndex, stopCodon);
        if (output != -1){
            System.out.println("Error: " + output + " instead of -1");
        } else {
            System.out.println("test passed");
        }
        System.out.println("Tests Completed!");
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
    
    
    public void testFindGene(){
        // Case 1
        System.out.println("Case1");
        //                vvv                  vvv
        String dna = "AATCATGCCTGTAAGTAGAATTGAGTAAGCCATC";
        String output = findGene(dna, 0);
        System.out.println(output);
        System.out.println();
        
        // Case 2
        System.out.println("Case2");
        //         vvv      vvv
        dna = "AATCATGCCTGTATAGTTCTGAAGGTAGGCCATC";
        output = findGene(dna, 0);
        System.out.println(output);
        System.out.println();
        
        // Case 3
        System.out.println("Case3");
        //         vvv            vvv
        dna = "AATCATGCCTAATCTGTACTGAATTAGTTGAGCCATC";
        output = findGene(dna, 0);
        System.out.println(output);
        System.out.println();
        
        // Case 4
        System.out.println("Case4");
        //         vvv            
        dna = "AATCATGCCTAATCTGTACTTGAATATAGTTGAGCCATC";
        output = findGene(dna, 0);
        System.out.println(output);
        System.out.println();
        System.out.println("test finished");
    }
    
    public void printAllGenes(String dna){
        int startIndex = 0;
        while (true) {
            // Find gene after start index
            String currGene = findGene(dna, startIndex);
            // If no gene was found, leave the loop
            if (currGene.isEmpty()){
                break;
            }
            System.out.println("Found gene: " + currGene + " in DNA strand");
            // Set startIndex to just past the currGene
            startIndex = currGene.length() + dna.indexOf(currGene, startIndex);                    
        }
    }
    
    public void testOn(String testDNA){
        System.out.println("Testing printAllGenes on " + testDNA);
        printAllGenes(testDNA);
        System.out.println();
    }
    
    public void testFindAllGene(){
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGATCCTCTCCAAGTAGCCTA");
        testOn("");
        testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAAATGTTCATGTAGTTATGCGCTGA");
    }
}
