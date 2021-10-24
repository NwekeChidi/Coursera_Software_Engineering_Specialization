
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.ArrayList;

public class CharactersInPlay {
    
    private ArrayList<String> charNames;
    private ArrayList<Integer> charCounts;
    
    public CharactersInPlay(){
        charNames = new ArrayList<String>();
        charCounts = new ArrayList<Integer>();
    }
    
    public void update(String person){
        int idx = charNames.indexOf(person);
        if (idx != -1){
            int currCount = charCounts.get(idx);
            charCounts.set(idx, currCount+1);
        } else {
            charNames.add(person);
            charCounts.add(1);
        }
    }
    
    public void findAllCharacters(){
        charNames.clear();
        charCounts.clear();
        FileResource fr = new FileResource();
        for (String line : fr.lines()){
            int idxOfPeriod = line.indexOf(".");
            if ( idxOfPeriod != -1){
                String person = line.substring(0,idxOfPeriod);
                update(person);
            }
        }
    }
    
    public void charactersWithNumParts(int num1, int num2){
        int partNum = 0;
        for (int i=0; i<charNames.size(); i++){
            partNum = charCounts.get(i);
            if (partNum >= num1 && partNum <= num2){
                System.out.println(charNames.get(i)+"\t"+charCounts.get(i));
            }
        }
    }
    
    public int findIndexOfMax(){
        int maxIndex = 0;
        int maxCount = 0;
        for (int i=0; i<charCounts.size(); i++){
            int currMax = charCounts.get(i);
            if (currMax > maxCount){
                maxCount = currMax;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public void tester(){
        findAllCharacters();
        for (int i=0; i<charNames.size(); i++){
            System.out.println(charNames.get(i)+"\t"+charCounts.get(i));
        }
        int maxIdx = findIndexOfMax();
        System.out.println("\nCharacter with max speaking parts is: "+
                        charNames.get(maxIdx)+", with "+charCounts.get(maxIdx)+
                        " speaking parts.\n");
        charactersWithNumParts(10, 15);
    }

}
