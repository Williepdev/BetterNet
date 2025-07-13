package athleteTypes;

import java.util.*;
import java.io.*;

public class Jumper extends Athlete implements Serializable{
    private static final long serialVersionUID = 1L;

    public Jumper(String name, String userName, Team team, String gender, ArrayList<Result> results, ArrayList<EventProformance> attempts)
    {
        super(name, userName, team, gender, results, attempts);
        checkResults();
        
    }
    
    private void checkResults()
    {
        for(Result i : results)
        {
            if(!(i.getEvent() instanceof JumpEvent))
            {
                if(i.getEvent() instanceof Relay)
                {
                    break;
                    //anybody can have results of a Relay
                }
                throw new IllegalArgumentException("You cannot be a Sprinter if you have non track events in your results");
            }
            
        }
    }
}