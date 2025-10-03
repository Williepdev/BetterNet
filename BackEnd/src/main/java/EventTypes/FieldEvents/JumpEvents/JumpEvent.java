package EventTypes.FieldEvents.JumpEvents;

import EventDivision.Flight;
import EventTypes.FieldEvents.FieldEvent;

import java.io.Serializable;
import java.util.ArrayList;
public class JumpEvent extends FieldEvent implements Serializable{
    private static final long serialVersionUID = 1L;


    public JumpEvent(String name, String gender, String unitType, ArrayList<Flight> flights, int numTrials)
    {
        super(name, gender, unitType, flights, numTrials);
    }

}