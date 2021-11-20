
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceFilter implements Filter {
    private double maxDist;
    private Location loc;
    private String name;
    
    public DistanceFilter(Location location, double maxi, String title){
        loc = location;
        maxDist = maxi;
        name = title;
    }
    
    public boolean satisfies(QuakeEntry qe){
        return qe.getLocation().distanceTo(loc) < maxDist;
    }
    
    public String getName(){
        return name;
    }
}
