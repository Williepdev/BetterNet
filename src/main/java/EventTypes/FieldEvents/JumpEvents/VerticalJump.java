package EventTypes.FieldEvents.JumpEvents;

import EventDivision.Flight;

import java.io.Serializable;
import java.util.ArrayList;
public class VerticalJump extends JumpEvent implements Serializable{
    private static final long serialVersionUID = 1L;

    private double startingHeight;

    public VerticalJump(String name, String gender, String unitType, ArrayList<Flight> flights, int numTrials, double startingHeight)
    {
        super(name, gender, unitType, flights, numTrials);
        this.startingHeight = startingHeight;
    }
}