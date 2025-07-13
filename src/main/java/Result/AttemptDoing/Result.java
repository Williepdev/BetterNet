package Result.AttemptDoing;

import java.util.*;
import java.io.*;
public class Result implements Serializable{
    private static final long serialVersionUID = 1L;

    private Athlete athlete;
    private Event event;
    private double proformance; //in seconds, minutes, feet, etc
    private String status;//Completed, foul, DNS, DNF, Scratch
    private String advancedStatus;//sector foul, toeboard/foot, false start, etc

    
    public Result(Athlete athlete, Event event, double proformance,
    String status, String advancedStatus)
    {
        if(proformance < 0)
        {
            throw new IllegalArgumentException("A time or distance cannot be negative");
        }
        if(!(status.toLowerCase().equals("completed")))
        {
            this.proformance = 0;//proformance will show as a zero whenever their is no mark
        }

        this.athlete = athlete;
        this.event = event;
        this.proformance = proformance;
        this.status = status;
        this.advancedStatus = advancedStatus;
    
        if(athlete.getResults().indexOf(this) == -1)
        {
            athlete.addResult(this);
        }
    }
    
    public Result(Athlete athlete, Event event, double proformance,
    String status)
    {

        if(proformance < 0)
        {
            throw new IllegalArgumentException("A time or distance cannot be negative");
        }
        if(!(status.equals("Completed")))
        {
            this.proformance = 0;
        }

        this.athlete = athlete;
        this.event = event;
        this.proformance = proformance;
        this.status = status;
        this.advancedStatus = "N/A";

        
    }
    
    public Athlete getAthlete()
    {
        return athlete;
    }
    

    public Event getEvent()
    {
        return event;
    }
    
    public double getProformance()
    {
        return proformance;
    }
    
    public String getStatus()
    {
        return status + ", advanced status is "  + advancedStatus;
    }
    

    public String getAdvancedStatus()
    {
        return advancedStatus;
    }

    public void setProformance(double proformance)
    {
        if(proformance < 0)
        {
        throw new IllegalArgumentException("A time or distance cannot be negative");
        }

        this.proformance = proformance;
    }
    
    public String toString()
    {
        if(!(advancedStatus.equals("N/A")))
        {
            return athlete.getName() + " - " + proformance + " " + event.getUnits() + " (" + status + ") ";
        }
        else
            return athlete.getName() + " - " + proformance + " " + event.getUnits() + " (" + advancedStatus + ") ";
    }


    public String getUnits()
    {
        return event.getUnits();
    }

    public void convert(String units)
    {
        if(units.equals("Meters") && event.getUnits().equals("Feet"))
        {//converting feet to meters
            proformance *= 0.3048;
            event.setUnits(units);
        }
    }
    


    public void printResult()
    {
        System.out.println(athlete.getName() + " - " + proformance + " " + event.getUnits() + " (" + status + ") ");
    }
    
    

}