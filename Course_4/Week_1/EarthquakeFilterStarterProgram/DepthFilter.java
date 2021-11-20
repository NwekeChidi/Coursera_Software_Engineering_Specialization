
/**
 * Write a description of DepthFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DepthFilter implements Filter {
    private double minDepth, maxDepth;
    private String name;
    
    public DepthFilter(double min, double maxi, String title){
        minDepth = min;
        maxDepth = maxi;
        name = title;
    }
    
    public boolean satisfies(QuakeEntry qe){
        return qe.getDepth() >= minDepth && qe.getDepth() <= maxDepth;
    }
    
    public String getName(){
        return name;
    }
}
