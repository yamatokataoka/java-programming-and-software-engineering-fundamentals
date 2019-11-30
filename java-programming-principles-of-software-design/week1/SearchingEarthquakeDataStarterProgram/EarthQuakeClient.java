import java.util.*;
import edu.duke.*;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry qe : quakeData) {
            if (qe.getMagnitude() > magMin) {
                answer.add(qe);
            }
        }
        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
    double distMax,
    Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry qe : quakeData) {
            if (qe.getLocation().distanceTo(from) < distMax) {
                answer.add(qe);
            }
        }
        return answer;
    }
    
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData,
        double minDepth,
        double maxDepth) {

        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry qe : quakeData) {
            if (minDepth < qe.getDepth() && qe.getDepth() < maxDepth) {
                answer.add(qe);
            }
        }
        return answer;
    }
    
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData,
                                                String where,
                                                String phrase) {
    
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry qe : quakeData) {
            String title = qe.getInfo();
            int index = title.indexOf(phrase);
            if ((where.equals("start") && index == 0)
                || (where.equals("end") && title.endsWith(phrase))
                || (where.equals("any") && index != -1)) {
                answer.add(qe);
            }
        }
        return answer;
    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }

    public void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        ArrayList<QuakeEntry> answer = filterByMagnitude(list, 5.0);
        for (QuakeEntry qe : answer) {
            System.out.println(qe);
        }
        System.out.println("Found " + answer.size()
            + " quakes that match that criteria");
    }

    public void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
        // String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        // This location is Durham, NC
        Location city = new Location(35.988, -78.907);

        // This location is Bridgeport, CA
        // Location city =  new Location(38.17, -118.82);

        // specified by meters
        int distMax = 1000000;
        ArrayList<QuakeEntry> answer = filterByDistanceFrom(list, distMax, city);
        for (QuakeEntry qe : answer) {
            double distanceInMeters = qe.getLocation().distanceTo(city);
            System.out.println(distanceInMeters/1000 + " "
                + qe.getInfo());
        }
        System.out.println("Found " + answer.size()
            + " quakes that match that criteria");
    }
    
    public void quakesOfDepth() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom"; // practice quiz: 1 & review quiz: 1, 2
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        //ArrayList<QuakeEntry> answer = filterByDepth(list, -10000.0, -5000.0);
        //ArrayList<QuakeEntry> answer = filterByDepth(list, -8000.0, -5000.0); // practice quiz: 1
        //ArrayList<QuakeEntry> answer = filterByDepth(list, -12000.0, -10000.0); // review quiz: 1
        ArrayList<QuakeEntry> answer = filterByDepth(list, -4000.0, -2000.0); // review quiz: 2
        for (QuakeEntry qe : answer) {
            System.out.println(qe);
        }
        System.out.println("Found " + answer.size()
            + " quakes that match that criteria");
    }
    
     public void quakesByPhrase() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom"; // practice quiz: 2, 3, 4 & review quiz: 3, 4, 5
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        //ArrayList<QuakeEntry> answer = filterByPhrase(list, "end", "California");
        //ArrayList<QuakeEntry> answer = filterByPhrase(list, "start", "Explosion"); // practice quiz: 2
        //ArrayList<QuakeEntry> answer = filterByPhrase(list, "end", "California"); // practice quiz: 3
        //ArrayList<QuakeEntry> answer = filterByPhrase(list, "any", "Creek"); // practice quiz: 4
        //ArrayList<QuakeEntry> answer = filterByPhrase(list, "start", "Quarry Blast"); // review quiz: 3
        //ArrayList<QuakeEntry> answer = filterByPhrase(list, "end", "Alaska"); // review quiz: 4
        ArrayList<QuakeEntry> answer = filterByPhrase(list, "any", "Can"); // review quiz: 5
        for (QuakeEntry qe : answer) {
            System.out.println(qe);
        }
        System.out.println("Found " + answer.size()
            + " quakes that match that criteria");
    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    
}
