
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part3 {
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
    
    
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        // This method returns the index of the first occurence of stopCodon taht
        //appears past startIndex and is a multiple of 3 away from startIndex.
        // Checking if dna strand is in upper or lower case
        if (isStringUpperCase(dna) == true){
            dna = dna.toUpperCase();
        }
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
        // Defining start and stop codons
        String initDna = dna;
        String startCodon = "atg";
        String taaStopCodon = "taa";
        String tagStopCodon = "tag";
        String tgaStopCodon = "tga";
        // Checking if dna strand is in upper or lower case
        if (isStringUpperCase(dna) == true){
            dna = dna.toUpperCase();
            startCodon = startCodon.toUpperCase();
            taaStopCodon = taaStopCodon.toUpperCase();
            tagStopCodon = tagStopCodon.toUpperCase();
            tgaStopCodon = tgaStopCodon.toUpperCase();
        }
        // Get the index of the startCodon
        int startIndex = dna.indexOf(startCodon, where);
        if (startIndex == -1){
            return "";
        }
        // Get indices of stopCodons which are multiples of 3 away from the startCodon
        int taaIndex = findStopCodon(dna, startIndex, taaStopCodon);
        int tagIndex = findStopCodon(dna, startIndex, tagStopCodon);
        int tgaIndex = findStopCodon(dna, startIndex, tgaStopCodon);
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
        if (isStringUpperCase(initDna) == true){
            result = result.toUpperCase();
        }
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
    
    public double cgRatio(String dna){
        // Defining working variables
        String cSymbol = "c";
        String gSymbol = "g";
        int count = 0;
        int cIndex = 0;
        int gIndex = 0;
        // Checking if dna strand is in upper or lower case
        if (isStringUpperCase(dna) == true){
            dna = dna.toUpperCase();
            cSymbol = cSymbol.toUpperCase();
            gSymbol = gSymbol.toUpperCase();
        }
        while (true){
            // Get indices of the symbols
            int currCIdx = dna.indexOf(cSymbol, cIndex);
            int currGIdx = dna.indexOf(gSymbol, gIndex);
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
    
    public void processGenes(String dna){
        StorageResource sr = getAllGenes(dna);
        
        /////// Attributes
        // Print all strings in sr longer than 60 characters
        System.out.println("Genes longer than 60 characters:");
        for (String s: sr.data()){
            if (s.length() > 60){
                System.out.println(s);
            }
        }
        
        // Print the count of strings in sr longer than 60 characters
        System.out.println("Number of Genes longer than 60 characters:");
        int count = 0;
        for (String s: sr.data()){
            if (s.length() > 60){
                count+=1;
            }
        }
        System.out.println(count);
        
        // Print genes whose C-G ratio is higher than 0.35
        System.out.println("Genes with C-G ratio higher than 0.35:");
        for (String s: sr.data()){
            double sCgRatio = cgRatio(s);
            if (sCgRatio > 0.35){
                System.out.println(sCgRatio);
            }
        }
        
        // Print the count of genes whose C-G ratio is higher than 0.35
        System.out.println("Number of Genes with C-G ratio higher than 0.35:");
        count = 0;
        for (String s: sr.data()){
            double sCgRatio = cgRatio(s);
            if (sCgRatio > 0.35){
                count+=1;
            }
        }
        System.out.println(count);
        
        // Print the length of the longest gene in sr
        System.out.println("Length of longest gene:");
        int maxGeneLength = 0;
        for (String s: sr.data()){
            if (s.length() > maxGeneLength){
                maxGeneLength = s.length();
            }
        }
        System.out.println(maxGeneLength);
        
        // Print all genes in dna
        System.out.println("Number of genes found in the strand:");
        count = 0;
        for (String s: sr.data()){
            count += 1;
        }
        System.out.println(count);
    }
    
    public void testProcessGenes(){
        // Case 1
        System.out.println("Case 1");
        String dna = "ATGGGACAGGTGTAAAATGCCTCCGTTGTTCTGAACTGGTATGTAAAATGTAGT";
        System.out.println("Given DNA strand: \n"+dna);
        processGenes(dna);
        System.out.println();
        
        // Case 2
        System.out.println("Case 2");
        FileResource fr = new FileResource("brca1line.fa");
        dna = fr.asString();
        System.out.println("Given DNA strand: \n"+dna);
        processGenes(dna);
        System.out.println();
    }
    
}
