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
        //String source = "data/nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom"; // practice quiz: 1, 2
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        Filter mf = new MagnitudeFilter(4.0, 5.0); // practice quiz: 2
        ArrayList<QuakeEntry> mList = filter(list, mf);
        Filter df = new DepthFilter(-35000.0, -12000.0); // practice quiz: 2
        ArrayList<QuakeEntry> dmList = filter(mList, df);
        //Filter df = new DistanceFilter(new Location(35.42,139.43), 10000000); // practice quiz: 1
        //ArrayList<QuakeEntry> dList = filter(list, df);
        //Filter pf = new PhraseFilter("end", "Japan"); // practice quiz: 1
        //ArrayList<QuakeEntry> dpList = filter(dList, pf);
        for (QuakeEntry qe: dmList) { 
            System.out.println(qe);
        } 
        System.out.println("Found " + dmList.size()
            + " quakes that match that criteria");
    }
    
    public void testMatchAllFilter() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom"; // practice quiz: 3 & review quiz: 8, 9, 10
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        MatchAllFilter maf = new MatchAllFilter();
        //Filter mf = new MagnitudeFilter(0.0, 2.0); // practice quiz: 3
        //Filter mf = new MagnitudeFilter(3.5, 4.5); // review quiz: 9
        Filter mf = new MagnitudeFilter(1.0, 4.0); // review quiz: 10
        maf.addFilter(mf);
        //Filter df = new DepthFilter(-100000.0, -10000.0); // practice quiz: 3
        //Filter df = new DistanceFilter(new Location(39.7392, -104.9903), 1000000); // review quiz: 8
        //Filter df = new DepthFilter(-55000.0, -20000.0); // review quiz: 9
        Filter df = new DepthFilter(-180000.0, -30000.0); // review quiz: 10
        maf.addFilter(df);
        //Filter pf = new PhraseFilter("any", "a"); // practice quiz: 3
        //Filter pf = new PhraseFilter("end", "a"); // review quiz: 8
        Filter pf = new PhraseFilter("any", "o"); // review quiz: 10
        maf.addFilter(pf);
        ArrayList<QuakeEntry> mafList = filter(list, maf);
        for (QuakeEntry qe: mafList) { 
            System.out.println(qe);
        }
        System.out.println("Found " + mafList.size()
            + " quakes that match that criteria");
        System.out.println(maf.getName());
    }
    
    public void testMatchAllFilter2() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom"; // practice quiz: 4 & review quiz: 11
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        MatchAllFilter maf = new MatchAllFilter();
        //Filter mf = new MagnitudeFilter(0.0, 3.0); // practice quiz: 4
        Filter mf = new MagnitudeFilter(0.0, 5.0); // review quiz: 11
        maf.addFilter(mf);
        //Filter df = new DistanceFilter(new Location(36.1314,-95.9372), 10000000); // practice quiz: 4
        Filter df = new DistanceFilter(new Location(55.7308, 9.1153), 3000000); // review quiz: 11
        maf.addFilter(df);
        //Filter pf = new PhraseFilter("any", "Ca"); // practice quiz: 4
        Filter pf = new PhraseFilter("any", "e"); // review quiz: 11
        maf.addFilter(pf);
        ArrayList<QuakeEntry> mafList = filter(list, maf);
        for (QuakeEntry qe: mafList) { 
            System.out.println(qe);
        }
        System.out.println("Found " + mafList.size()
            + " quakes that match that criteria");
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
