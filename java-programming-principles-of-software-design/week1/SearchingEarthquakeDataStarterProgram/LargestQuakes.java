
/**
 * Write a description of LargestQuakes here.
 * 
 * @author yamatokataoka
 * @version November 29th, 2019
 */

import java.util.*;

public class LargestQuakes {
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany) {
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        if (quakeData.size() < howMany) {
            howMany = quakeData.size();
        }
        for (int j=0; j<howMany; j++) {
            int maxIndex = indexOfLargest(copy);
            ret.add(copy.get(maxIndex));
            copy.remove(maxIndex);
        }
        return ret;
    }

    public int indexOfLargest(ArrayList<QuakeEntry> data) {
        int maxIndex = 0;
        for (int k=0; k<data.size(); k++) {
            QuakeEntry qe = data.get(k);
            if (qe.getMagnitude() > data.get(maxIndex).getMagnitude()) {
                maxIndex = k;
            }
        }
        return maxIndex;
    }

    public void findLargestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom"; // practice quiz: 5, 6 & review quiz: 6, 7
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size());
        // for(int k=0; k < list.size(); k++){
        //     System.out.println(list.get(k));
        // }
        //ArrayList<QuakeEntry> largest = getLargest(list,5);
        //ArrayList<QuakeEntry> largest = getLargest(list,20); // review quiz: 6
        ArrayList<QuakeEntry> largest = getLargest(list,50); // review quiz: 7
        for (QuakeEntry qe : largest) {
            System.out.println(qe);
        }
        System.out.println("number found: "+list.size());
    }
}
