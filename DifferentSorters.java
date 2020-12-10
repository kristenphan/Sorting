
/**
 * Run different sorters with comparable and comparator interface
 */

import java.util.*;

public class DifferentSorters {
    public void sortWithCompareTo() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/earthQuakeDataWeekDec6sample2.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list);
        // testing: correct output for file "nov20quakedata.atom" at position 10 = 
        // (36.75, -116.15), mag = -0.20, depth = -4200.00, title = 57km ESE of Beatty, Nevada
        int quakeNumber = 600;
        System.out.println("func: sortWithCompareTo()" + "\n" + 
                            "Filename: " + source + "\n" + 
                            "Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
    }    

    public void sortByMagnitude() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new MagnitudeComparator());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }

    public void sortByDistance() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        // Location is Durham, NC
        Location where = new Location(35.9886, -78.9072);
        Collections.sort(list, new DistanceComparator(where));
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }
    
    public void sortByTitleAndDepth() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/earthQuakeDataWeekDec6sample1.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        TitleAndDepthComparator tdc = new TitleAndDepthComparator();
        Collections.sort(list, tdc);
        // testing: correct output for file "nov20quakedata.atom" at position 10 is:
        // (49.76, 155.83), mag = 4.70, depth = -58380.00, title = 104km SSW of Severo-Kuril'sk, Russia
        int quakeNumber = 500;
        System.out.println("func: sortByTitleAndDepth()" + "\n" + 
                            "Filename: " + source + "\n" + 
                            "Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
    }
    
    public void sortByLastWordInTitleThenByMagnitude() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/earthQuakeDataWeekDec6sample1.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        TitleLastAndMagnitudeComparator tlmc = new TitleLastAndMagnitudeComparator();
        Collections.sort(list, tlmc);
        // testing: correct output for file "nov20quakedata.atom" at position 10 is:
        // (64.47, -149.48), mag = 0.40, depth = -16300.00, title = 21km WSW of North Nenana, Alaska
        int quakeNumber = 500;
        System.out.println("func: sortByLastWordInTitleThenByMagnitude()" + "\n" + 
                            "Filename: " + source + "\n" + 
                            "Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
    }
    
    public static void main(String[] args) {
        DifferentSorters ds = new DifferentSorters();
        ds.sortByTitleAndDepth();
    }
}
