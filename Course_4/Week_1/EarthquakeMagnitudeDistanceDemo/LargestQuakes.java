
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
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        /*
        for (QuakeEntry qe : list) {
           System.out.println(qe); 
        }
        */
        System.out.println("Read data for " + list.size() + " quakes");
        int idxMaxDepth = indexOfLargest(list), howMany = 5;
        System.out.println("Index of earthquake with max depth: "+idxMaxDepth+ ", with magnitude: "
                            +list.get(idxMaxDepth).getMagnitude());
        System.out.println("\nThe first "+howMany+" largest quakes in file are:");
        ArrayList<QuakeEntry> largest = getLargest(list, howMany);
        for(QuakeEntry qe : largest){
            System.out.println(qe);
        }
    }
    
    public int indexOfLargest(ArrayList<QuakeEntry> data){
        int idx = 0, runIdx = 0;
        double currMax = 0.0;
        for (QuakeEntry qe : data) {
            if (qe.getMagnitude() > currMax) {
                idx = runIdx;
                currMax = qe.getMagnitude();
            }
            runIdx++;
        }
        return idx;
    }
    
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> largest = new ArrayList<QuakeEntry>();
        ArrayList<QuakeEntry> copy = quakeData;
        for (int i = 0; i < howMany; i++){
            largest.add(copy.get(indexOfLargest(copy)));
            copy.remove(copy.get(indexOfLargest(copy)));
        }
        return largest;
    }
}
