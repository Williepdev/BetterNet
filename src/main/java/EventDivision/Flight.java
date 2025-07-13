package EventDivision;

import java.util.*;
import java.io.*;

public class Flight extends EventDivision implements Serializable{
    private static final long serialVersionUID = 1L;

    public Flight(int divisionNumber, ArrayList<EventEntry> entries, Event event)
    {
        super(divisionNumber, entries, event);
    }

    @Override
    public void sortEntries()
    {
        
        for (int i = 0; i < getEntries().size() - 1; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < getEntries().size(); j++)
            {
                if (getEntries().get(j).getMark().getProformance() < getEntries().get(minIndex).getMark().getProformance())
                {
                    minIndex = j;
                }
            }
            // Swap entries
            EventEntry temp = getEntries().get(i);
            getEntries().set(i, getEntries().get(minIndex));
            getEntries().set(minIndex, temp);
        }
    }
}