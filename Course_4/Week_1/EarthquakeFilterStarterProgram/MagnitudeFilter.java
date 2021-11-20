
/**
 * Write a description of MagnitudeFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagnitudeFilter implements Filter {
    
    private double minMag, maxMag;
    
    public MagnitudeFilter(double min, double maxi){
        minMag = min;
        maxMag = maxi;
    }
    
    public boolean satisfies(QuakeEntry qe){
        return qe.getMagnitude() >= minMag && qe.getMagnitude() <= maxMag;
    }
    
    public String getName(){
        return "Magnitude Filter";
    }
}
