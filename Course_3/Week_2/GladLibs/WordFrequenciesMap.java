
/**
 * Write a description of WordFrequenciesMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class WordFrequenciesMap {
    
    public void countWords(){
        FileResource fr = new FileResource();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        //int total = 0;
        for (String w : fr.words()){
            w = w.toLowerCase();
            if (map.keySet().contains(w)){
                map.put(w,map.get(w)+1);
            } else {
                map.put(w,1);
            }
        }
        System.out.println("# Unique words : "+map.size());
        for (String w : map.keySet()){
            int occurrences = map.get(w);
            if (occurrences > 500){
                System.out.println(occurrences+"\t"+w);
            }
        }
    }
}
