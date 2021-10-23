
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class WordLengths {
    public void countWordLengths(FileResource resource){
        String maxWord = "";
        int[] counts = new int[35];
        int idx = 0;
        for(String word : resource.words()){
            int currCount = word.length();
            if(!(Character.isLetter(word.charAt(0)))){
                currCount --;
            }
            if(!(Character.isLetter(word.charAt(word.length()-1)))){
                currCount --;
            }
            if(currCount >= counts.length){
                currCount = counts.length - 4;
                maxWord = word;
            }
            if(currCount == -1){
                currCount = counts.length - 1;
                maxWord = word;
            }
            counts[currCount] += 1;
            idx += 1;
            
        }
        for(int k=1; k<counts.length; k++){
            System.out.println("Number of words with length '"+k+"': "+counts[k]);
        }
        int maxIdx = indexOfMax(counts);
        System.out.println("Index of maximum word in file: "+maxIdx);
    }
    
    public int indexOfMax(int[] arr){
        int maxIdx = 0;
        int currMax = 0;
        for(int i=0; i<arr.length; i++){
            if(currMax < arr[i]){
                maxIdx = i;
                currMax = arr[i];
            }
        }
        return maxIdx;
    }
    
    public void testCountWordLenghts(){
        System.out.println("\nTesting method 'countWordLengths'....");
        FileResource resource = new FileResource();
        countWordLengths(resource);
    }
}
