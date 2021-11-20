
/**
 * Write a description of DepthFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DepthFilter implements Filter {
    private double minDepth, maxDepth;
    
    public DepthFilter(double min, double maxi){
        minDepth = min;
        maxDepth = maxi;
    }
    
    public boolean satisfies(QuakeEntry qe){
        return qe.getDepth() >= minDepth && qe.getDepth() <= maxDepth;
    }
    
    public String getName(){
        return "Depth Filter";
    }
}
