package LiveResults;

import EventTypes.Event;
import EventTypes.FieldEvents.FieldEvent;
import EventTypes.TrackEvent;
import MeetClasses.Meet;
import PeopleTypes.Athlete;

import java.io.Serializable;
import java.util.ArrayList;

public class EventProformance implements Serializable{
    private static final long serialVersionUID = 1L;
    private Athlete athlete;
    private Event event;
    private ArrayList<Result> trials;//(prelims, finals), throws
    private Meet meet;
    
    /* This class is used to take the all times an athlete has competed
    in an event and combine those results, for example: a sprinter wins his or her
    event and then moves on to finals, both of these will be in the ArrayList
    of Result called trials, and for field athletes this will store all trials
    in an event at a meet*/
    
    public EventProformance(Athlete athlete, Event event)
    {
        this.athlete = athlete;
        this.event = event;
        this.trials = new ArrayList<>();
    }
    
    public void verifyEvents()
    {
        for(Result r : trials)
        {
            if(!(r.getEvent().equals(event)))
            {
                throw new IllegalArgumentException("Trials must all be of the same event as event");
            }
        }
    }
    
    public void addTrial(Result r)
    {
        trials.add(r);
        verifyEvents();
    }
    
    public Result getBestTrial()
    {
        Result best = null;
        if(event instanceof FieldEvent)
        {
            for(Result r : trials)
            {
                if(best.getProformance() > r.getProformance())
                {
                    best = r;
                }
            }
        }
        else if(event instanceof TrackEvent)
        {
            for(Result r : trials)
            {
                if(best.getProformance() < r.getProformance())
                {
                    best = r;
                }
            }
        }
        
        return best;
    }
    
    public Athlete getAthlete()
    {
        return athlete;
    }
    
    public Event getEvent()
    {
        return event;
    }
    
    public void sortTrials()//sortTrials by mark
    {
    
    if(event instanceof FieldEvent)
    {
        for (int i = 0; i < trials.size() - 1; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < trials.size(); j++)
            {
                if(trials.get(j).getProformance() < trials.get(minIndex).getProformance())
                {
                    minIndex = j;
                }
            }
            // Swap entries
            Result temp = trials.get(i);
            trials.set(i, trials.get(minIndex));
            trials.set(minIndex, temp);
        }
    }
    else if(event instanceof TrackEvent)
    {
        for (int i = 0; i < trials.size() - 1; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < trials.size(); j++)
            {
                if(trials.get(j).getProformance() >= trials.get(minIndex).getProformance())
                {
                    minIndex = j;
                }
            }
            // Swap entries
            Result temp = trials.get(i);
            trials.set(i, trials.get(minIndex));
            trials.set(minIndex, temp);
        }
    }
}

}