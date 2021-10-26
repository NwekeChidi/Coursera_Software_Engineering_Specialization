
/**
 * Write a description of CodonCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
import java.io.*;
public class CodonCount {
    
    private HashMap<String,Integer> codonMap;
    
    public CodonCount(){
        codonMap = new HashMap<String,Integer>();
    }
    
    private void buildCodonMap(int start, String dna){
        codonMap.clear();
        for(int i=start; i<dna.length(); i+=3){
            if (i+3 <= dna.length()){
                String currCodon = dna.substring(i, i+3);
                if(codonMap.keySet().contains(currCodon)){
                    codonMap.put(currCodon,codonMap.get(currCodon)+1);
                } else {
                    codonMap.put(currCodon,1);
                }
            }
        }
    }
    
    private String getMostCommonCodon(){
        String mCodon = "";
        int maxCount = 0;
        for (String codon : codonMap.keySet()){
            if (codonMap.get(codon) > maxCount){
                mCodon = codon;
                maxCount = codonMap.get(codon);
            }
        }
        return mCodon;
    }
    
    private void printCodonCounts(int start, int end){
        System.out.println("Codons with counts between "+start+" and "+
                            end+" inclusive are:");
        for (String codon : codonMap.keySet()){
            if (codonMap.get(codon)>= start && codonMap.get(codon)<=end){
                System.out.println("\n"+codon+"\t"+codonMap.get(codon));
            }
        }
    }
    
    public void tester(){
        FileResource fr = new FileResource();
        String dna = fr.asString().toUpperCase().trim();
        int[] rframe = {0,1,2};
        int start = 1, end = 5;
        for (int i : rframe){
            buildCodonMap(i, dna);
            System.out.println("\nReading frame starting with "+i+" results in "+
                             codonMap.size()+" unique codons");
            System.out.println("Most common codon and its count is: "+getMostCommonCodon()+
                        " with count "+codonMap.get(getMostCommonCodon()));
            printCodonCounts(start, end);
        }
    }
}
