
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
import java.io.*;

public class WordsInFiles {
    
    private HashMap<String,ArrayList<String>> wordMap;
    
    public WordsInFiles(){
        wordMap = new HashMap<String,ArrayList<String>>();
    }
    
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        String fname = f.getName();;
        for (String word : fr.words()){
            ArrayList<String> update = new ArrayList<String>();
            if (wordMap.keySet().contains(word)){
                update = wordMap.get(word);
                update.add(fname);
                wordMap.put(word,update);
            } else {
                update.add(fname);
                wordMap.put(word,update);
            }
        }
    }

}
