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
    
    public void getMatchSize(ArrayList<QuakeEntry> m){
        System.out.println("\nFound "+m.size()+" quakes that match filtering criteria");
    }

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        String source = "data/nov20quakedata.atom";
        //String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        /*
        Filter f1 = new MagnitudeFilter(3.5, 4.5, "Magnitude"); 
        Filter f2 = new DepthFilter(-55000.0, -20000.0, "Depth");
        ArrayList<QuakeEntry> m7  = filter(filter(list, f1), f2);
        */
        
        
        Location loc = new Location(35.42, 139.43);
        String phrase = "Japan", where = "end";
        double maxDist = 10000000;
        Filter f2 = new DistanceFilter(loc, maxDist, "Distance");
        Filter f1 = new PhraseFilter(phrase, where, "Phrase");
        ArrayList<QuakeEntry> m7 = filter(filter(list, f1), f2);
        
        
        for (QuakeEntry qe: m7) { 
            System.out.println(qe);
        }
        
        getMatchSize(m7);
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
    
    public void testMatchAllFilter(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        String source = "data/nov20quakedata.atom";
        //String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes\n");
        
        MatchAllFilter maf = new MatchAllFilter();
        Filter f1 = new MagnitudeFilter(1.0, 4.0, "Magnitude"), f2 = new DepthFilter(-180000.0, -30000.0, "Depth"), f3 = new PhraseFilter("o", "any", "Phrase");
        maf.addFilter(f1);
        maf.addFilter(f2);
        maf.addFilter(f3);
        
        ArrayList<QuakeEntry> m8 = filter(list, maf);
        for (QuakeEntry qe : m8){
            System.out.println(qe);
        }
        getMatchSize(m8);
        maf.getName();
    }
    
    public void testMatchAllFilter2(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        String source = "data/nov20quakedata.atom";
        //String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes\n");
        
        MatchAllFilter maf = new MatchAllFilter();
        Location loc = new Location(55.7308, 9.1153);
        double maxDist = 3000000;
        Filter f1 = new MagnitudeFilter(0.0, 5.0, "Magnitude"), f2 = new DistanceFilter(loc, maxDist, "Distance"), f3 = new PhraseFilter("e", "any", "Phrase");
        maf.addFilter(f1);
        maf.addFilter(f2);
        maf.addFilter(f3);
        
        ArrayList<QuakeEntry> m8 = filter(list, maf);
        for (QuakeEntry qe : m8){
            System.out.println(qe);
        }
        
        getMatchSize(m8);
        maf.getName();
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
