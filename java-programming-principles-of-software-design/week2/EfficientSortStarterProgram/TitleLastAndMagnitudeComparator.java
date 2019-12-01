
/**
 * Write a description of TitleLastAndMagnitudeComparator here.
 * 
 * @author yamatokataoka
 * @version December 1st, 2019
 */

import java.util.*;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        String q1Last = q1.getInfo().substring(q1.getInfo().lastIndexOf(' '));
        String q2Last = q2.getInfo().substring(q2.getInfo().lastIndexOf(' '));
        if (q1Last.equals(q2Last)) {
            return Double.compare(q1.getMagnitude(), q2.getMagnitude());
        } else {
            return q1Last.compareTo(q2Last);
        }
    }
}
