import java.util.*;

/**
 * Implement a Comparator of type QuakeEntry 
 * to sort earthquakes by the last word in their titles lexicographically
 * and break ties by magnitude (from smallest to largest)
 */
public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        String[] q1Title = q1.getInfo().split("\\s+");
        String[] q2Title = q2.getInfo().split("\\s+");
        String q1Last = q1Title[q1Title.length - 1];
        String q2Last = q2Title[q2Title.length - 1];
        
        if (!q1Last.equals(q2Last)) { 
            return q1Last.compareTo(q2Last);
        }
        else { // break ties by magnitude
            if (q1.getMagnitude() < q2.getMagnitude()) {
                return -1;
            }
            else if (q1.getMagnitude() > q2.getMagnitude()) {
                return 1;
            }
            return 0;
        }
    }
}
