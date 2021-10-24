
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.ArrayList;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        FileResource resource = new FileResource();
        for (String s : resource.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index != -1){
                int value = myFreqs.get(index);
                myFreqs.set(index, value+1);;
            }
            else {
                myWords.add(s);
                myFreqs.add(1);
            }
        }
    }
    
    public int findIndexOfMax(){
        int maxIndex = 0;
        int maxCount = 0;
        for (int i=0; i<myFreqs.size(); i++){
            int currMax = myFreqs.get(i);
            if (currMax > maxCount){
                maxCount = currMax;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public void tester(){
        findUnique();
        System.out.println("# unique words: "+myWords.size());
        for (int i=0; i<myWords.size(); i++){
            System.out.println(myFreqs.get(i)+"\t"+myWords.get(i));
        }
        int maxIndex = findIndexOfMax();
        System.out.println("The word that occurs most often and its count are:- "+
                            maxIndex+" "+myWords.get(maxIndex));
    }
}
