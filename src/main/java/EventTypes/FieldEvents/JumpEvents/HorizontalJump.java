package EventTypes.FieldEvents.JumpEvents;

import java.util.*;
import java.io.*;
public class HorizontalJump extends JumpEvent implements Serializable{
    private static final long serialVersionUID = 1L;

    public HorizontalJump(String name, String gender, String unitType, ArrayList<Flight> flights, int numTrials)
    {
        super(name, gender, unitType, flights, numTrials);
    }

}