package TeamTypes;

import java.util.*;
import java.io.*;
public abstract class TrackTeam extends Team implements Serializable{
    private static final long serialVersionUID = 1L;

    public TrackTeam(ArrayList<Athlete> roster, ArrayList<Coach> coaches,
    String name, String teamLevel, ArrayList<String> divisions)
    {
        super(roster, coaches, name, teamLevel, divisions);
    }

}