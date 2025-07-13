package TeamTypes;

import java.util.*;
import java.io.*;
public class IndoorTeam extends TrackTeam implements Serializable{
    private static final long serialVersionUID = 1L;

    public IndoorTeam(ArrayList<Athlete> roster, ArrayList<Coach> coaches,
    String name, String teamLevel, ArrayList<String> divisions)
    {
        super(roster, coaches, name, teamLevel, divisions);
    }
}