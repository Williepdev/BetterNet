package EventDivision;

import EventTypes.Event;
import LiveResults.EventEntry;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class EventDivision implements Serializable{
    private static final long serialVersionUID = 1L;
    
    protected int divisionNumber;
    protected ArrayList<EventEntry> entries;
    protected Event event;
    
    public EventDivision(int divisionNumber, ArrayList<EventEntry> entries, Event event)
    {
        this.divisionNumber = divisionNumber;
        this.entries = entries;
        this.event = event;
    }
    
    public void addEntry(EventEntry entry)
    {
        entries.add(entry);
    }
    
    public int getDivisionNumber()
    {
        return divisionNumber;
    }

    public ArrayList<EventEntry> getEntries()
    {
        return entries;
    }

    public Event getEvent()
    {
        return event;
    }

    public int getNumberOfEntries()
    {
        return entries.size();
    }

    public abstract void sortEntries();

    
    
}