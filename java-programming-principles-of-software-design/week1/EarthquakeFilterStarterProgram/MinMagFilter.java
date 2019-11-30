
/**
 * Write a description of class MinMaxFilter here.
 * 
 * @author yamatokataoka
 * @version November 30th, 2019
 */
public class MinMagFilter implements Filter
{
    private double magMin; 
    
    public MinMagFilter(double min) { 
        magMin = min;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return qe.getMagnitude() >= magMin; 
    } 

}
