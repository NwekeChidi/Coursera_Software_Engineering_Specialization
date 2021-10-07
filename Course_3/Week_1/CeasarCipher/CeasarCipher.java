
/**
 * Write a description of CeasarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;
public class CeasarCipher {
    public String encrypt(String input, int key){
        // Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        // Count from 0 < length of encrypted
        for (int i=0; i< encrypted.length(); i++){
            // Write down the alphabet
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            // Compute shifted alphabet
            String shiftedAlphabet = alphabet.substring(key) +
                            alphabet.substring(0, key);
            // Look at the ith character of encrypted
            char currChar = encrypted.charAt(i);
            // Check the case of the current character
            if (Character.isUpperCase(currChar)){
                // if true, convert alphabet and shifted alphabet toLowerCase
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
    
    public void testCeasar(int key){
        FileResource fr =  new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message,key);
        System.out.println("Encrypted: \n"+encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println("Decrypted: \n"+decrypted);
    }
}
