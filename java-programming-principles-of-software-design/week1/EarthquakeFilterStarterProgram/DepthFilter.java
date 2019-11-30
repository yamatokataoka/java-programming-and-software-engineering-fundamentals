
/**
 * Write a description of DepthFilter here.
 * 
 * @author yamatokataoka
 * @version November 30th, 2019
 */
public class DepthFilter implements Filter{
    private double minimumDepth;
    private double maximumDepth;

    public DepthFilter(double minDepth, double maxDepth) {
        minimumDepth = minDepth;
        maximumDepth = maxDepth;
    }
    
    public boolean satisfies(QuakeEntry qe) { 
        return minimumDepth <= qe.getDepth()
                && qe.getDepth() <= maximumDepth; 
    } 
}
