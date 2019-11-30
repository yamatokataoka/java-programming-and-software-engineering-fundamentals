
/**
 * Write a description of MagnitudeFilter here.
 * 
 * @author yamatokataoka
 * @version November 30th, 2019
 */
public class MagnitudeFilter implements Filter{
    private double minimumMagnitude;
    private double maximumMagnitude;

    public MagnitudeFilter(double minMag, double maxMag) {
        minimumMagnitude = minMag;
        maximumMagnitude = maxMag;
    }
    
    public boolean satisfies(QuakeEntry qe) { 
        return minimumMagnitude <= qe.getMagnitude()
                && qe.getMagnitude() <= maximumMagnitude; 
    } 
}
