
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
    public String findGeneSimple(String dna){
        // This method finds the gene in a dna strand
        // Print the DNA strand given
        System.out.println("The given DNA strand is " + dna);
        // start codon is "ATG"
        // stop codon is "TAA"
        String result1 = "";
        String result2 = "There is no Gene is this DNA strand, e.g. no start or stop codon";
        
        // get the index of the start codon
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            //ATG not in DNA strand
            return result2;
        }
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        if (stopIndex == -1){
            //TAA not in DNA strand
            return result2;
        }
        result1 = dna.substring(startIndex, stopIndex+3);
        if ( (result1.length() % 3) == 0 ){
            // Checking if gene is valid
            return "The Gene in the DNA strand is : " + result1;
        } else {
            return "The Gene found in the DNA strand is invalid";
        }
    }
    
    public void testSimpleGene(){
        // Case 1
        System.out.println("Case 1");
        String dna = "AAATGTGATGAATAAGTGAAGAGAAGTTTAGATTTAAGT";
        String output = findGeneSimple(dna);
        System.out.println(output);
        
        // Case 2 
        System.out.println("Case 2");
        dna = "TTGATGTGATGTTTAGGGATGTTAGTAGT";
        output = findGeneSimple(dna);
        System.out.println(output);
        
        // Case 3
        System.out.println("Case 3");
        dna = "TTTATGGGTGGAAGATAATAATGATGGAAGGA";
        output = findGeneSimple(dna);
        System.out.println(output);
        
        // Case 4
        System.out.println("Case 4");
        dna = "AATAATAAGAGGTTGGGAGGT";
        output = findGeneSimple(dna);
        System.out.println(output);
        
        // Case 5
        System.out.println("Case 5");
        dna = "ATTGGATTGAATAAGTT";
        output = findGeneSimple(dna);
        System.out.println(output);
    }
}

    
