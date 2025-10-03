package EventTypes;

import EventDivision.EventDivision;
import LiveResults.EventResults;
import LiveResults.Result;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Event implements Serializable{
    private static final long serialVersionUID = 1L;
    
    protected String name;
    protected String gender;
    protected String units;
    protected ArrayList<EventDivision> groups;
    protected EventResults results;

    public Event(String name, String gender, String units, ArrayList<EventDivision> groups)
    {
        this.name = name;
        this.gender = gender;
        this.units = units;
        this.groups = groups;
        this.results = null;
    }
    
    public void setResults(EventResults results)
    {
        this.results = results;
    }
    
    public EventResults getResults()
    {
        return results;
    }
    
    public ArrayList<Result> getFinalStandings()
    {
        results.sortResults();
        return results.getBests();
    }

    public String getName()
    {
        return name;
    }

    public String getGender()
    {
        return gender;
    }

    public String getUnits()
    {
        return units;
    }
    
    public void setUnits(String units)
    {
        this.units = units;
    }

    public ArrayList<EventDivision> getDivisions()
    {
        return groups;
    }
}