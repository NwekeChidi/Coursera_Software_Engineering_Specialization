
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
        int decryptKey = getKey(encrypted);
        System.out.println("The encryption key is: "+decryptKey);
        return cc.encrypt(encrypted, 26-decryptKey);
    }
    
    public void testDecrypt(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = cc.encrypt(message, 15);
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
    
    public int getKey(String s){
        int[] freqLetters = co.countLetters(s);
        int maxIdx = co.maxIndex(freqLetters);
        int decryptKey = maxIdx - 4; // supposedly, letter 'e' at index 4 is the most occurring letter
        if(maxIdx < 4){
            decryptKey = 26 - (4-maxIdx);
        }
        return decryptKey;
    }
    
    public String decryptTwoKeys(String encrypted){
        String halfEncrypt0 = halfOfString(encrypted, 0);
        String halfEncrypt1 = halfOfString(encrypted, 1);
        // get encryption keys
        int encryptKey0 = getKey(halfEncrypt0);
        int encryptKey1 = getKey(halfEncrypt1);
        // print keys found
        System.out.println("The encryption keys found are: "+encryptKey0+" and "+encryptKey1);
        return cc.encryptTwoKeys(encrypted, 26-encryptKey0, 26-encryptKey1);
    }
    
    public void testDecryptTwoKeys(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        //message = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
        String encrypted = cc.encryptTwoKeys(message, 21, 8);
        System.out.println("\nEncrypted Message: \n"+encrypted);
        String decrypted = decryptTwoKeys(encrypted);
        System.out.println("\nDecrypted Message: \n"+decrypted);
    }
}
