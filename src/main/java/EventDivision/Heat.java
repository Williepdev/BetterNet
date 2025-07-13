package EventDivision;

import java.util.*;
import java.io.*;

public class Heat extends EventDivision implements Serializable{
    private static final long serialVersionUID = 1L;

    public Heat(int divisionNumber, ArrayList<EventEntry> entries, Event event)
    {
        super(divisionNumber, entries, event);
    }

    @Override
    public void sortEntries()
    {
        for (int i = 0; i < getEntries().size() - 1; i++)
        {
            int maxIndex = i;
            for (int j = i + 1; j < getEntries().size(); j++)
            {
                if (getEntries().get(j).getMark().getProformance() > getEntries().get(maxIndex).getMark().getProformance())
                {
                    maxIndex = j;
                }
            }
            // Swap entries
            EventEntry temp = getEntries().get(i);
            getEntries().set(i, getEntries().get(maxIndex));
            getEntries().set(maxIndex, temp);
        }
    }
}