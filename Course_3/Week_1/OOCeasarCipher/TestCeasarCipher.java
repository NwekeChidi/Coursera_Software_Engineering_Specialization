
/**
 * Write a description of TestCeasarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class TestCeasarCipher {
    // Writing private methods
    private int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int i=0; i<message.length(); i++){
            char ch = Character.toLowerCase(message.charAt(i));
            int idx = alph.indexOf(ch);
            if (idx != -1){
                counts[idx] += 1;
            }
        }
        return counts;
    }
    
    private int maxIndex(int[] vals){
        int maxIdx = 0;
        for(int i=0; i < vals.length; i++){
            if (vals[i] > vals[maxIdx]){
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    
    private int getKey(String s){
        int[] freqLetters = countLetters(s);
        int maxIdx = maxIndex(freqLetters);
        int decryptKey = maxIdx - 4; // supposedly, letter 'e' at index 4 is the most occurring letter
        if(maxIdx < 4){
            decryptKey = 26 - (4-maxIdx);
        }
        return decryptKey;
    }
    
    //Writing public methods
    public void simpleTests(){
        FileResource fr = new FileResource();
        String input = fr.asString();
        System.out.println("Given Input: \n"+input);
        CeasarCipher cc = new CeasarCipher(18);
        String encrypted = cc.encrypt(input);
        System.out.println("Encrypted Message: \n"+encrypted);
        System.out.println("Decrypted Message: \n"+cc.decrypt(encrypted));
        System.out.println("Automatically Decrypted Message:");
        System.out.println(breakCeasarCipher(encrypted));
    }
    
    public String breakCeasarCipher(String input){
        int decryptKey = getKey(input);
        System.out.println("The encryption key is: "+decryptKey);
        CeasarCipher cc = new CeasarCipher(decryptKey);
        return cc.decrypt(input);
    }
}
