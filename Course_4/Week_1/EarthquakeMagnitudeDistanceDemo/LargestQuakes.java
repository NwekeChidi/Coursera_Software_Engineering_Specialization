
/**
 * Write a description of LargestQuakes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class LargestQuakes {

    public void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        /*
        for (QuakeEntry qe : list) {
           System.out.println(qe); 
        }
        */
        System.out.println("read data for " + list.size() + " quakes");
    }
    
    public
}
