
/**
 * Write a description of MatchAllFilter here.
 * 
 * @author yamatokataoka
 * @version November 30th, 2019
 */

import java.util.*;

public class MatchAllFilter implements Filter{
    private ArrayList<Filter> filterList;

    public MatchAllFilter() {
        filterList = new ArrayList<Filter>();
    }
    
    public void addFilter(Filter f) {
        filterList.add(f);
    }
    
    public boolean satisfies(QuakeEntry qe) {
        for (Filter f : filterList) {
            if (!f.satisfies(qe)) {
                return false;
            }
        }
        return true;
    }
}
