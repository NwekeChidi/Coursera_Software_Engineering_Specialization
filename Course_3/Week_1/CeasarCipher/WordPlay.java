
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class WordPlay {
    public boolean isVowel(char ch){
        String vowels = "aeiou";
        if (vowels.indexOf(Character.toLowerCase(ch)) != -1){
            return true;
        } else {
            return false;
        }
    }
    
    public String replaceVowels(String phrase, char ch){
        StringBuilder output = new StringBuilder(phrase);
        for(int i=0; i<output.length(); i++){
            if(isVowel(output.charAt(i))){
                output.setCharAt(i, '*');
            }
        }
        return output.toString();
    }
    
    public String emphasize(String phrase, char ch){
        StringBuilder output = new StringBuilder(phrase);
        for(int i=0; i<output.length(); i++){
            // check if char at current index
            if(Character.toLowerCase(output.charAt(i))==
            Character.toLowerCase(ch)){
                // check if i is even
                if(i%2 != 0){
                    output.setCharAt(i, '+');
                } else {
                    output.setCharAt(i, '*');
                }
            }
        }
        return output.toString();
    }
}
