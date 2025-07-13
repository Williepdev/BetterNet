package EventTypes.FieldEvents;

import java.util.*;
import java.io.*;
public class ThrowEvent extends FieldEvent implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private double minMark;

    public ThrowEvent(String name, String gender, String unitType, ArrayList<Flight> flights, int numTrials)
    {
        super(name, gender, unitType, flights, numTrials);
        minMark = 0.0;//no minimum mark, 
    }
    
    public ThrowEvent(String name, String gender, String unitType, ArrayList<Flight> flights, int numTrials, double minMark)
    {
        super(name, gender, unitType, flights, numTrials);
        this.minMark = minMark;
    }
    
    
}