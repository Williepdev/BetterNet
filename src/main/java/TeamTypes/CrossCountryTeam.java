package TeamTypes;

import java.util.*;
import java.io.*;
public class CrossCountryTeam extends Team implements Serializable{
    private static final long serialVersionUID = 1L;
    private ArrayList<DistanceRunner> roster;

    public CrossCountryTeam(ArrayList<DistanceRunner> roster, ArrayList<Coach> coaches,
    String name, String teamLevel, ArrayList<String> divisions)
    {
        super(new ArrayList<Athlete>(roster), coaches, name, teamLevel, divisions);
    }
}