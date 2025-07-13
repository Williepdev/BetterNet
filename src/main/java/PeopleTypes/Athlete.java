package PeopleTypes;

import java.util.*;
import java.io.*;
public abstract class Athlete extends Person implements Serializable{
    private static final long serialVersionUID = 1L;

protected Team team;
protected ArrayList<Result> results;
protected ArrayList<Result> prs;
protected ArrayList<EventProformance> attempts;

    public Athlete(String name, String userName, Team team, String gender, ArrayList<Result> results, 
    ArrayList<EventProformance> attempts)
    {
        super(name, userName, gender);
        this.team = team;
        team.addAthlete(this);
        this.results = results;
        prs = new ArrayList<>();
        this.attempts = attempts;
    }
    
    public String getTeamName()
    {
        return team.getName();
    }

    public Team getTeam()
    {
        return team;
    }

    public void addResult(Result result)
    {
        results.add(result);
    }

    public ArrayList<Result> getResults()
    {
        return results;
    }
    
    public ArrayList<Result> getPrs()
    {
        return prs;
    }
    
    public void setPrs()
    {
        prs = new ArrayList<>();
        
        for(Result r : results)
        {
            if(!r.getStatus().equals("Completed")){
                continue;//skips if no mark is provided
            }
            
            String eventName = r.getEvent().getName();
            boolean found = false;//pr of x event is not found (yet)
            
            for(int i = 0; i < prs.size(); i++)
            {
                /*seeing if a pr of the event already exists*/
                Result currentPr = prs.get(i);
                if(currentPr.getEvent().getName().equals(eventName))
                {
                    if(isBetter(r, currentPr))
                    {
                        prs.set(i, r);
                    }
                    found = true;
                    break;
                }
            }
            if(!found)
            {
                prs.add(r);
            }
        }
    }
    
    public ArrayList<EventProformance> getProformances()
    {
        return attempts;
    }
    
    private boolean isBetter(Result newResult, Result currentPr)//helper method for setPrs
    {
        Event event = newResult.getEvent();
        
        if(event instanceof FieldEvent)
        {
            return newResult.getProformance() > currentPr.getProformance();
        }
            return newResult.getProformance() < currentPr.getProformance();
    
    }

    public void printResults()
    {
        for(Result i : results)
        {
            System.out.println(i);
        }
    }
    
    public String toString()
    {
        return name + " from " + team.getName();
    }

}