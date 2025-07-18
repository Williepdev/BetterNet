package AthleteTypes;

import EventTypes.Event;
import EventTypes.FieldEvents.JumpEvents.JumpEvent;
import EventTypes.Relay;
import LiveResults.EventProformance;
import LiveResults.Result;
import PeopleTypes.Athlete;
import TeamTypes.Team;

import java.io.Serializable;
import java.util.ArrayList;

public class Jumper extends Athlete implements Serializable{
    private static final long serialVersionUID = 1L;

    public Jumper(String name, String userName, Team team, String gender, ArrayList<Result> results, ArrayList<EventProformance> attempts)
    {

            super(name, userName, team, gender, results, attempts);
            try
            {
                checkResults();
                //if results are not valid, an exception will be thrown
            }
        catch (Exception e)
        {
            for(Result result : results) {
                Event event = result.getEvent();
                if(event instanceof JumpEvent ||event instanceof Relay) {
                    results.remove(result);
                }
            }
        }
    }
    
    private void checkResults()
    {

        for(Result i : results)
        {
            Event e = i.getEvent();
            if(!(e instanceof JumpEvent))
            {
                if(e instanceof Relay)
                {
                    continue;
                    //anybody can have results of a Relay
                }
                throw new IllegalArgumentException("You cannot be a Sprinter if you have non track events in your results");
            }
            
        }
    }
}