package EventTypes.FieldEvents.JumpEvents;

import EventTypes.FieldEvents.FieldEvent;

import java.util.*;
import java.io.*;
public class JumpEvent extends FieldEvent implements Serializable{
    private static final long serialVersionUID = 1L;


    public JumpEvent(String name, String gender, String unitType, ArrayList<Flight> flights, int numTrials)
    {
        super(name, gender, unitType, flights, numTrials);
    }

}