
/**
 * Write a description of class MagnitudeComparator here.
 * 
 * @author yamatokataoka
 * @version December 1st, 2019
 */

import java.util.*;

public class MagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry qe1, QuakeEntry qe2) {
        return Double.compare(qe1.getMagnitude(), qe2.getMagnitude());
    }
    
}
