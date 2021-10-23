
/**
 * Write a description of CeasarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class CeasarCipherTwo {
    // Write down the alphabet
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int dKey1;
    private int dKey2;
    public CeasarCipherTwo (int key1, int key2){
        // Write down the alphabet
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        // Compute shifted alphabet
        shiftedAlphabet1 = alphabet.substring(key1) +
                            alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) +
                            alphabet.substring(0, key2);
        dKey1 = key1;
        dKey2 = key2;
    }
    public String encrypt(String input){
        // Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        // Count from 0 < length of encrypted
        for (int i=0; i< encrypted.length(); i++){
            // keep alphabet and shifted alphabet in lowercase
            alphabet = alphabet.toLowerCase();
            shiftedAlphabet1 = shiftedAlphabet1.toLowerCase();
            shiftedAlphabet2 = shiftedAlphabet2.toLowerCase();
            // Look at the ith character of encrypted
            char currChar = encrypted.charAt(i);
            // Check the case of the current character
            if (Character.isUpperCase(currChar)){
                // if true, convert alphabet and shifted alphabet toUpperCase
                alphabet = alphabet.toUpperCase();
                shiftedAlphabet1 = shiftedAlphabet1.toUpperCase();
                shiftedAlphabet2 = shiftedAlphabet2.toUpperCase();
            }
            // Find the index of currChar in the alphabet
            int idx = alphabet.indexOf(currChar);
            // If currChar is in the alphabet
            if (idx != -1 && i%2==0){
                // Get the idxth character of shiftedAlphabet
                char newChar = shiftedAlphabet1.charAt(idx);
                // Replace the ith character of enctripted
                encrypted.setCharAt(i, newChar);
            }
            if (idx != -1 && i%2!=0){
                // Get the idxth character of shiftedAlphabet
                char newChar = shiftedAlphabet2.charAt(idx);
                // Replace the ith character of enctripted
                encrypted.setCharAt(i, newChar);
            }
        }
        // Return answer
        return encrypted.toString();
    }
    
    public String decrypt(String input){
        CeasarCipherTwo cc2 = new CeasarCipherTwo(26-dKey1, 26-dKey2);
        return cc2.encrypt(input);
    }
}
