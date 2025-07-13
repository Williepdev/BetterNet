package TeamTypes;

import java.util.*;
import java.io.*;
public class OutdoorTeam extends TrackTeam implements Serializable{
    private static final long serialVersionUID = 1L;

    public OutdoorTeam(ArrayList<Athlete> roster, ArrayList<Coach> coaches,
    String name, String teamLevel, ArrayList<String> divisions)
    {
        super(roster, coaches, name, teamLevel, divisions);
    }
}