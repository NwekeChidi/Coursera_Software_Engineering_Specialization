
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
                if (!update.contains(fname)){
                    update.add(fname);
                    //wordMap.put(word,update);
                }
            } else {
                update.clear();
                update.add(fname);
                wordMap.put(word,update);
            }
        }
    }
    
    private int maxNumber(){
        int maxNum = 0;
        for (String key : wordMap.keySet()){
            if (wordMap.get(key).size() > maxNum){
                maxNum = wordMap.get(key).size();
            }
        }
        return maxNum;
    }
    
    private ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> wordList = new ArrayList<String>();
        for (String key : wordMap.keySet()){
            if (wordMap.get(key).size() == number){
                wordList.add(key);
            }
        }
        System.out.println("Words appearing in exactly "+number+" files:");
        System.out.println("Size: "+wordList.size());
        return wordList;
    }
    
    private void printFilesIn(String word){
        for(int i=0; i<wordMap.get(word).size(); i++){
            System.out.println(wordMap.get(word).get(i));
        }
    }
    
    public void buildWordFileMap(){
        wordMap.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    
    public void tester(){
        System.out.println("\nRunning WordsInFiles class ......\n\n");
        buildWordFileMap();
        System.out.println("Max number of files any word is in: "+maxNumber());
        System.out.println(wordsInNumFiles(4));
        //for (String key : wordMap.keySet()){
        //    System.out.println("\n"+key+":");
        //    printFilesIn(key);
        //}
        //System.out.println("\nWordMap: \n"+wordMap);
        printFilesIn("laid");
        System.out.println();
        printFilesIn("tree");
    }
}
