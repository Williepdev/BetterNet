package EventTypes;

import java.util.*;
import java.io.*;

public class TrackEvent extends Event implements Serializable{
    private static final long serialVersionUID = 1L;

    protected ArrayList<Heat> heats;
    protected int numOfHeats;
    protected int distance;//in meters
    
    public TrackEvent(String name, String gender, String unitType, ArrayList<Heat> heats, int distance)
    {
        //unit type secs/minutes
        super(name, gender, unitType, new ArrayList<EventDivision>(heats));
        this.distance = distance;
        this.numOfHeats = heats.size();
    }
    
    public double getNumLaps()
    {
        return (double)(distance / 400);
    }
}