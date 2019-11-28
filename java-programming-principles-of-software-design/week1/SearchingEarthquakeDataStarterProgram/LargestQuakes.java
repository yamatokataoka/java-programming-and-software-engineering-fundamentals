
/**
 * Write a description of LargestQuakes here.
 * 
 * @author yamatokataoka
 * @version November 29th, 2019
 */

import java.util.*;

public class LargestQuakes {
    public void findLargestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size());
        for(int k=0; k < list.size(); k++){
            System.out.println(list.get(k));
        }
        System.out.println("number found: "+list.size());
    }
}
