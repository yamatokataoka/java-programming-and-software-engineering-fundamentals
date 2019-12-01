
/**
 * Write a description of TitleAndDepthComparator here.
 * 
 * @author yamatokataoka
 * @version December 1st, 2019
 */

import java.util.*;

public class TitleAndDepthComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        if (q1.getInfo().equals(q2.getInfo())) {
            return Double.compare(q1.getDepth(), q2.getDepth());
        } else {
            return q1.getInfo().compareTo(q2.getInfo());
        }
    }
}
