import java.util.*;

/**
 * Implement a Comparator of type QuakeEntry to sort earthquakes by their titles and depth
 * Quakes should be sorted lexicographically and break ties by comparing their depth 
 * (smallest i.e. most negative to largest depth)
 */
public class TitleAndDepthComparator implements Comparator<QuakeEntry> {
    private String title;
    
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        if (!q1.getInfo().equals(q2.getInfo())) { 
            return q1.getInfo().compareTo(q2.getInfo());
        }
        else { // break ties uding depths
            if (q1.getDepth() < q2.getDepth()) {
                return -1;
            }
            else {
                return 1;
            }
        }
    }
}
