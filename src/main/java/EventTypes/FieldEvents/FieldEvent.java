package EventTypes.FieldEvents;

import java.util.*;
import java.io.*;
public class FieldEvent extends Event implements Serializable{
    private static final long serialVersionUID = 1L;

    protected ArrayList<Flight> flights;
    protected int numberOfFlights;
    protected int numTrials;
    
    public FieldEvent(String name, String gender, String unitType, ArrayList<Flight> flights, int numTrials)
    {
        //convert flights to EventDivision
        //unit type feet or meters
        super(name, gender, unitType, new ArrayList<EventDivision>(flights));
        
        numberOfFlights = flights.size();
        this.numTrials = numTrials;
    }
    
    
    
    
}