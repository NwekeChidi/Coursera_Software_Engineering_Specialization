
/**
 * Write a description of CeasarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class CeasarBreaker {
    CeasarCipher cc = new CeasarCipher();
    CountOccurrence co = new CountOccurrence();
    
    public String decrypt(String encrypted){
        int[] freqLetters = co.countOccurrence(encrypted);
        int maxIdx = co.maxIndex(freqLetters);
        int decryptKey = maxIdx - 4; // supposedly, letter 'e' at index 4 is the most occurring letter
        if(maxIdx < 4){
            decryptKey = 26 - (4-maxIdx);
        }
        System.out.println("The encryption key is: "+decryptKey);
        return cc.encrypt(encrypted, 26-decryptKey);
    }
    
    public void testDecrypt(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = cc.encrypt(message, 20);
        System.out.println("\nEncrypted Message: \n"+encrypted);
        String decrypted = decrypt(encrypted);
        System.out.println("\nDecrypted Message: \n"+decrypted);
    }
    
    public String halfOfString(String message, int start){
        StringBuilder halfString = new StringBuilder();
        for(int i=start; i < message.length(); i+=2){
            halfString.append(Character.toString(message.charAt(i)));
        }
        return halfString.toString();
    }
}
