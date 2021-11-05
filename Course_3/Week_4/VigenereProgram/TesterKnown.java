
/**
 * Write a description of TesterKnown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class TesterKnown {
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
    
    public void testReadDictionary(){
        FileResource fr = new FileResource();
        HashSet<String> dictSet = vb.readDictionary(fr);
        System.out.println(dictSet);
    }
}
