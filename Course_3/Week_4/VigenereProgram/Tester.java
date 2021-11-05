
/**
 * Write a description of TesterKnown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class Tester {
    VigenereBreaker vb = new VigenereBreaker();
    
    public void testSliceString(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        int[] itr = {0, 1, 2, 3};
        int totalSlices = 4;
        //for (int whichSlice: itr){
        //    System.out.println("\n On whichSlice = "+whichSlice+", resulting string is: \n"+
        //            vb.sliceString(message, whichSlice, totalSlices));
        //}
    }
    
    public void testTryKeyLength(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        System.out.println("Found Key list with length: ");
        int[] keyList = vb.tryKeyLength(message, 4, 'e');
        System.out.print("[ ");
        for (int key : keyList){
            System.out.print(key+", ");
        }
        System.out.println("]");
    }
    
    public void testReadDictionary(){
        FileResource fr = new FileResource();
        HashSet<String> dictSet = vb.readDictionary(fr);
        System.out.println(dictSet);
    }
    
    public void testBreakVigenereUnknownKey(){
        System.out.println("Starting Decryption......\n\n");
        vb.breakVigenere();
        System.out.println("\n\nCompleted Decryption!");
    }
    
    public void testBreakVigenereKnownKey(){
        FileResource fr = new FileResource("messages/secretmessage2.txt");
        String encrypted = fr.asString();
        int[] keyList = vb.tryKeyLength(encrypted, 38, 'e');
        VigenereCipher vc = new VigenereCipher(keyList);
        String decrypted = vc.decrypt(encrypted);
        FileResource dictFr = new FileResource("dictionaries/English");
        HashSet<String> dict = vb.readDictionary(dictFr);
        int currRealWords = vb.countWords(decrypted, dict);
        System.out.println(currRealWords);
    }
    
    public void testMostCommonChar(){
        FileResource dictFr = new FileResource("dictionaries/English");
        HashSet<String> dict = vb.readDictionary(dictFr);
        System.out.println("Most Common Character In English: "+vb.mostCommonCharIn(dict));
    }
}
