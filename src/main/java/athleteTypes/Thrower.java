package athleteTypes;

import java.util.*;
import java.io.*;

public class Thrower extends Athlete implements Serializable{
    private static final long serialVersionUID = 1L;
    public Thrower(String name, String userName, TrackTeam team, String gender, ArrayList<Result> results, ArrayList<EventProformance> attempts)
    {
        super(name, userName, team, gender, results, attempts);
        //results contains only coint result of ThrowEvents
        checkResults();
    }
    
    private void checkResults()
    {
        for(Result i : results)
        {
            if(!(i.getEvent() instanceof ThrowEvent))
            {
                if(i.getEvent() instanceof Relay)
                {
                    break;
                    //anybody can have results of a Relay
                    //so 4 by fat does not crash the software
                }
                throw new IllegalArgumentException("You cannot be a Thrower if you have non track events in your results");
            }
        }
    }
    

    
}