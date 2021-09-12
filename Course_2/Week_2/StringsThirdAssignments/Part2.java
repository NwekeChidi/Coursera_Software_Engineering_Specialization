
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public double cgRatio(String dna){
        int count = 0;
        int cIndex = 0;
        int gIndex = 0;
        while (true){
            // Get indices of the symbols
            int currCIdx = dna.indexOf("C", cIndex);
            int currGIdx = dna.indexOf("G", gIndex);
            // Defining break statement
            if (currCIdx == -1 && currGIdx == -1){
                break;
            }
            if (currCIdx != -1){
                count += 1;
                cIndex = currCIdx + 1;
            }
            if (currGIdx != -1){
                count += 1;
                gIndex = currGIdx + 1;
            }
        }
        return (double) count/dna.length();
    }
    
    public void testCgRatio(){
        // Case 1
        System.out.println("Case 1");
        String dna = "ATGCCATAG";
        System.out.println("DNA strand: "+dna);
        System.out.println("The CG ratio to DNA is: "+cgRatio(dna));
        System.out.println();
        
        System.out.println("Case 2");
        dna = "ATCCATA";
        System.out.println("DNA strand: "+dna);
        System.out.println("The CG ratio to DNA is: "+cgRatio(dna));
        System.out.println();
        
        System.out.println("Case 4");
        dna = "ATGGGGATA";
        System.out.println("DNA strand: "+dna);
        System.out.println("The CG ratio to DNA is: "+cgRatio(dna));
        System.out.println();
        
        System.out.println("Case 5");
        dna = "ATATA";
        System.out.println("DNA strand: "+dna);
        System.out.println("The CG ratio to DNA is: "+cgRatio(dna));
        System.out.println();
    }
    
    public int countCTG(String dna){
        int startIndex = dna.indexOf("CTG");
        int count = 0;
        int currIndex = 0;
        while (startIndex != -1){
            count += 1;
            currIndex = startIndex + 3;
            startIndex = dna.indexOf("CTG", currIndex);
        }
        return count;
    }
    
    public void testCountCTG(){
        // case 1
        System.out.println("Case 1");
        String dna = "ATGAACTGAATTGAATCTGCCTA";
        System.out.println("DNA strand: "+dna);
        System.out.println("Counting 'CTG' occurance in DNA strand....");
        int output = countCTG(dna);
        System.out.println("Answer: " + output);
        System.out.println();
        
        // case 2
        System.out.println("Case 2");
        dna = "CTGCTGAACTG";
        System.out.println("DNA strand: "+dna);
        System.out.println("Counting 'CTG' occurance in DNA strand....");
        output = countCTG(dna);
        System.out.println("Answer: " + output);
        System.out.println();
        
        // case 3
        System.out.println("Case 3");
        dna = "CTTCTAACTT";
        System.out.println("DNA strand: "+dna);
        System.out.println("Counting 'CTG' occurance in DNA strand....");
        output = countCTG(dna);
        System.out.println("Answer: " + output);
        System.out.println();
    }
}
