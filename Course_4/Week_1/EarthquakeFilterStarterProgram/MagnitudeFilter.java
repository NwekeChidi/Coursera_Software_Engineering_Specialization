
/**
 * Write a description of MagnitudeFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagnitudeFilter implements Filter {
    
    private double minMag, maxMag;
    private String name;
    
    public MagnitudeFilter(double min, double maxi, String title){
        minMag = min;
        maxMag = maxi;
        name = title;
    }
    
    public boolean satisfies(QuakeEntry qe){
        return qe.getMagnitude() >= minMag && qe.getMagnitude() <= maxMag;
    }
    
    public String getName(){
        return name;
    }
}
