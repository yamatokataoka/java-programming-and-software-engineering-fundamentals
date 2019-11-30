import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        //Filter mf = new MagnitudeFilter(4.0, 5.0);
        //ArrayList<QuakeEntry> mList = filter(list, mf);
        //Filter df = new DepthFilter(-35000.0, -12000.0);
        //ArrayList<QuakeEntry> dmList = filter(mList, df);
        Filter df = new DistanceFilter(new Location(35.42,139.43), 10000000);
        ArrayList<QuakeEntry> dList = filter(list, df);
        Filter pf = new PhraseFilter("end", "Japan");
        ArrayList<QuakeEntry> dpList = filter(dList, pf);
        for (QuakeEntry qe: dpList) { 
            System.out.println(qe);
        } 
    }
    
    public void testMatchAllFilter() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        MatchAllFilter maf = new MatchAllFilter();
        Filter mf = new MagnitudeFilter(0.0, 2.0);
        maf.addFilter(mf);
        Filter df = new DepthFilter(-100000.0, -10000.0);
        maf.addFilter(df);
        Filter pf = new PhraseFilter("any", "a");
        maf.addFilter(pf);
        ArrayList<QuakeEntry> mafList = filter(list, maf);
        for (QuakeEntry qe: mafList) { 
            System.out.println(qe);
        }
    }
    
    public void testMatchAllFilter2() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        MatchAllFilter maf = new MatchAllFilter();
        Filter mf = new MagnitudeFilter(0.0, 3.0);
        maf.addFilter(mf);
        Filter df = new DistanceFilter(new Location(36.1314,-95.9372), 10000000);
        maf.addFilter(df);
        Filter pf = new PhraseFilter("any", "Ca");
        maf.addFilter(pf);
        ArrayList<QuakeEntry> mafList = filter(list, maf);
        for (QuakeEntry qe: mafList) { 
            System.out.println(qe);
        }
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

}
