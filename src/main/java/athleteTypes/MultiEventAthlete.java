package athleteTypes;

import java.util.*;
import java.io.*;

public class MultiEventAthlete extends Athlete implements Serializable{
    private static final long serialVersionUID = 1L;

    public MultiEventAthlete(String name, String userName, Team team, String gender, ArrayList<Result> results, ArrayList<EventProformance> attempts)
    {
        super(name, userName, team, gender, results, attempts);
        //where results & attempts are of any Event
    }
}