
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    // Similar to "Part1 class but reorganized
    
    private static boolean isStringUpperCase(String str){
        // This method check if a string is upper or lower case
        //convert String to char array
        char[] charArray = str.toCharArray();
        
        for(int i=0; i < charArray.length; i++){
            
            //if any character is not in upper case, return false
            if( !Character.isUpperCase( charArray[i] ))
                return false;
        }
        
        return true;
    }
    
    public String findGeneSimple(String dna, String startCodon, String stopCodon){
        // This method finds the gene in a dna strand
        // Print the DNA strand given
        System.out.println("The given DNA strand is " + dna);
        // modify start and stop codons to fit DNA strands of all cases
        
        if (isStringUpperCase(dna) == false){
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        String result1 = "";
        String result2 = "There is no Gene is this DNA strand, e.g. no start or stop codon";
        
        // get the index of the start codon
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1){
            //ATG not in DNA strand
            return result2;
        }
        int stopIndex = dna.indexOf(stopCodon, startIndex+3);
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
        
        String startCodon = "ATG";
        String stopCodon = "TAA";
        // Case 1
        System.out.println("Case 1");
        String dna = "AAATGTGATGAATAAGTGAAGAGAAGTTTAGATTTAAGT";
        String output = findGeneSimple(dna, startCodon, stopCodon);
        System.out.println(output);
        
        // Case 2 
        System.out.println("Case 2");
        dna = "TTGATGTGATGTTTAGGGATGTTAGTAGT";
        output = findGeneSimple(dna, startCodon, stopCodon);
        System.out.println(output);
        
        // Case 3
        System.out.println("Case 3");
        dna = "TTTATGGGTGGAAGATAATAATGATGGAAGGA";
        output = findGeneSimple(dna, startCodon, stopCodon);
        System.out.println(output);
        
        // Case 4
        System.out.println("Case 4");
        dna = "AATAATAAGAGGTTGGGAGGT";
        output = findGeneSimple(dna, startCodon, stopCodon);
        System.out.println(output);
        
        // Case 5
        System.out.println("Case 5");
        dna = "ATTGGATTGAATAAGTT";
        output = findGeneSimple(dna, startCodon, stopCodon);
        System.out.println(output);
        
        // Case 6
        System.out.println("Case 6");
        dna = "tttatgggtggaagataataatgatggaagga";
        output = findGeneSimple(dna, startCodon, stopCodon);
        System.out.println(output);
        
        // Case 7
        System.out.println("Case 7");
        dna = "ATGGGTTAAGTC";
        output = findGeneSimple(dna, startCodon, stopCodon);
        System.out.println(output);
        
        // Case 8
        System.out.println("Case 8");
        dna = "gatgctataat";
        output = findGeneSimple(dna, startCodon, stopCodon);
        System.out.println(output);
    }
}
