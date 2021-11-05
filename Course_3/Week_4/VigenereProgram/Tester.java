
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
    
    public void testBreakVigenere(){
        System.out.println("Starting Decryption......\n\n");
        vb.breakVigenere();
        System.out.println("\n\nCompleted Decryption!");
    }
}
