package Result.AttemptDoing;

import java.io.*;
import java.util.*;

public class EventEntry implements Serializable{
    private static final long serialVersionUID = 1L;

    private Athlete athlete;
    private Event event;
    private Result mark;

    public EventEntry(Athlete athlete, Event event, Result mark)
    {
        this.athlete = athlete;
        this.event = event;
        this.mark = mark;
    }
    
    public Athlete getAthlete()
    {
        return athlete;
    }
    
    public Event getEvent()
    {
        return event;
    }
    
    public Result getMark()
    {
        return mark;
    }
    
    public Team getTeam()
    {
        return athlete.getTeam();
    }

/*
    public int getGroupRank()
    {
        
        return division.getEntries().indexOf(this) + 1; // Rank is 1-based
    }

    public int getRank()//get rank of whole event at meet
    {
        ArrayList<EventEntry> allEntries = new ArrayList<>();
        for(EventDivision i : event.getDivisions())
        {
            for(EventEntry j : i.getEntries())
            {
                allEntries.add(j);
            }
        }

        EventDivision tempDivision = new EventDivision(0, allEntries);//making a divison of all entries in one big flight/heat
        tempDivision.sortEntries(); // Sort all entries

        return allEntries.indexOf(this) + 1; // Rank is 1-based
    }
*/
}