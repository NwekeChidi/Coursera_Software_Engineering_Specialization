
/**
 * Write a description of TestCeasarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class TestCeasarCipherTwo {
    // Writing private methods
    private String halfOfString(String message, int start){
        StringBuilder halfString = new StringBuilder();
        for(int i=start; i < message.length(); i+=2){
            halfString.append(Character.toString(message.charAt(i)));
        }
        return halfString.toString();
    }
    
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
    
    // Writing public methods
    public void simpleTests(){
        System.out.println();
        FileResource fr = new FileResource();
        String input = fr.asString();
        System.out.println("Given Input (2-keys): \n"+input);
        CeasarCipherTwo cc2 = new CeasarCipherTwo(17, 3);
        String encrypted = cc2.encrypt(input);
        System.out.println("Encrypted Message (2-keys): \n"+encrypted);
        System.out.println("Decrypted Message (2-keys): \n"+cc2.decrypt(encrypted));
        System.out.println("Automatically Decrypted Message (2-keys):");
        System.out.println(breakCeasarCipher(encrypted));
    }
    
    public String breakCeasarCipher(String input){
        String halfEncrypt0 = halfOfString(input, 0);
        String halfEncrypt1 = halfOfString(input, 1);
        // get encryption keys
        int eKey0 = getKey(halfEncrypt0);
        int eKey1 = getKey(halfEncrypt1);
        CeasarCipherTwo cc2 = new CeasarCipherTwo(eKey0, eKey1);
        // print keys found
        System.out.println("The encryption keys found are: "+eKey0+" and "+eKey1);
        return cc2.decrypt(input);
    }
}
