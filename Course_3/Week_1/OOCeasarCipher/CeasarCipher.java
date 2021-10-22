
/**
 * Write a description of CeasarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;
public class CeasarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int decryptKey;
    // Write constructor
    public CeasarCipher(int key){
        // Write down the alphabet
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        // Compute shifted alphabet
        shiftedAlphabet = alphabet.substring(key) +
                          alphabet.substring(0, key);
        // get key
        decryptKey = 26-key;
    }
    
    public String encrypt(String input){
        // Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        // Count from 0 < length of encrypted
        for (int i=0; i< encrypted.length(); i++){
            // keep alphabet and shifted alphabet in lowercase
            alphabet = alphabet.toLowerCase();
            shiftedAlphabet = shiftedAlphabet.toLowerCase();
            // Look at the ith character of encrypted
            char currChar = encrypted.charAt(i);
            // Check the case of the current character
            if (Character.isUpperCase(currChar)){
                // if true, convert alphabet and shifted alphabet toUpperCase
                alphabet = alphabet.toUpperCase();
                shiftedAlphabet = shiftedAlphabet.toUpperCase();
            }
            // Find the index of currChar in the alphabet
            int idx = alphabet.indexOf(currChar);
            // If currChar is in the alphabet
            if (idx != -1){
                // Get the idxth character of shiftedAlphabet
                char newChar = shiftedAlphabet.charAt(idx);
                // Replace the ith character of enctripted
                encrypted.setCharAt(i, newChar);
            }
        }
        // Return answer
        return encrypted.toString();
    }
    
    public String decrypt(String input){
        CeasarCipher cc = new CeasarCipher(decryptKey);
        return cc.encrypt(input);
    }
}
