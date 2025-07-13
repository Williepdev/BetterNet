package Result.AttemptDoing;

import java.util.*;
import java.io.*;
public class EventResults implements Serializable{
    private static final long serialVersionUID = 1L;
    //event while running or completed
    
    private ArrayList<EventProformance> results;
    private ArrayList<Result> bests;
    //will get all info from that EventProformance
    
    public EventResults(ArrayList<EventProformance> results)
    {
        this.results = results;
        
        //gets all of the best marks of the competetion of each athlete
        for(EventProformance e : results)
        {
            bests.add(e.getBestTrial());
        }
    }
    
    public Event getEvent()
    {
        //all events are the same
        return results.get(0).getEvent();
    }
    
    public ArrayList<Result> getBests()
    {
        return bests;
    }
    
    public void sortResults()
    {
        //sorts FieldEvents to go from lowest distance to highest
        //sorts TrackEvents to go from longest time to fastest time
        if(getEvent() instanceof FieldEvent)
        {
            for (int i = 0; i < bests.size() - 1; i++)
            {
                int minIndex = i;

                for (int j = i + 1; j < bests.size(); j++)
                {
                    if(bests.get(j).getProformance() < bests.get(minIndex).getProformance())
                    {
                        minIndex = j;
                    }
                }
                // Swap entries
                Result temp = bests.get(i);
                bests.set(i, bests.get(minIndex));
                bests.set(minIndex, temp);
            }
        }
    else if(getEvent() instanceof TrackEvent)
    {
        for (int i = 0; i < bests.size() - 1; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < bests.size(); j++)
            {
                if(bests.get(j).getProformance() >= bests.get(minIndex).getProformance())
                {
                    minIndex = j;
                }
            }
            // Swap entries
            Result temp = bests.get(i);
            bests.set(i, bests.get(minIndex));
            bests.set(minIndex, temp);
        }
    }
    
    }
    
    public ArrayList<EventProformance> getResults()
    {
        return results;
    }
}