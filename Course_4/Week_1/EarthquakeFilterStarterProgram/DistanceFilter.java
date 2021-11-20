
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceFilter implements Filter {
    private double maxDist;
    private Location loc;
    
    public DistanceFilter(Location location, double maxi){
        loc = location;
        maxDist = maxi;
    }
    
    public boolean satisfies(QuakeEntry qe){
        return qe.getLocation().distanceTo(loc) < maxDist;
    }
}
