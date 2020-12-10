
public class QuakeEntry implements Comparable<QuakeEntry>{
    
    private Location myLocation;
    private String title;
    private double depth;
    private double magnitude;

    public QuakeEntry(double lat, double lon, double mag, 
                      String t, double d) {
        myLocation = new Location(lat,lon);
        
        magnitude = mag;
        title = t;
        depth = d;
    }
    
    public Location getLocation(){
        return myLocation;
    }
    
    public double getMagnitude(){
        return magnitude;
    }
    public String getInfo(){
        return title;
    }
    public double getDepth(){
        return depth;
    }

    @Override
    /**
     * Sort quakes by magnitude from smallest to largest magnitude
     * Break ties by depth, frpm smallest (most negative) to largest depth
     */
    public int compareTo(QuakeEntry loc) {
        if (magnitude < loc.getMagnitude()) {
           return -1; // sort quakes by magnitude, from smallest to largest magnitude
       }
       else if (magnitude > loc.getMagnitude()) {
           return 1;
       }
       else {
           if (depth < loc.getDepth()) { // break ties by depth, from smallest (most negative) to largest depth 
               return -1; 
           }
            else {
               return 1;
           }
       }
    }
    
    public String toString(){
        return String.format("(%3.2f, %3.2f), mag = %3.2f, depth = %3.2f, title = %s", myLocation.getLatitude(),myLocation.getLongitude(),magnitude,depth,title);
    }
    
}