
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class WordLengths {
    public void countWordLengths(FileResource resource, int[] counts){
        String maxWord = "";
        int idx = 0;
        for(String word : resource.words()){
            int currCount = word.length();
            if(!(Character.isLetter(word.charAt(0)))){
                currCount -= 1;
            }
            if(!(Character.isLetter(word.charAt(word.length()-1)))){
                currCount -= 1;
            }
            counts[idx] = currCount;
            idx += 1;
            System.out.println(word+": "+currCount);
        }
        int maxIdx = indexOfMax(counts);
        System.out.println("Index of maximum word in file: "+maxIdx);
    }
    
    public int indexOfMax(int[] arr){
        int maxIdx = 0;
        int currMax = 0;
        for(int i=0; i<arr.length; i++){
            if(currMax < arr[i]){
                maxIdx = i+1;
                currMax = arr[i];
            }
        }
        return maxIdx;
    }
    
    public void testCountWordLenghts(){
        System.out.println("\nTesting method 'countWordLengths'....");
        FileResource resource = new FileResource();
        int[] counts = new int[31];
        countWordLengths(resource, counts);
    }
}
