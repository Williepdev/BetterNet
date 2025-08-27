package TeamTypes;

import LiveResults.Division;
import PeopleTypes.Athlete;
import PeopleTypes.Coach;
import AthleteTypes.DistanceRunner;

import java.io.Serializable;
import java.util.ArrayList;
public class CrossCountryTeam extends Team implements Serializable{
    private static final long serialVersionUID = 1L;
    private ArrayList<DistanceRunner> roster;

    public CrossCountryTeam(ArrayList<DistanceRunner> roster, ArrayList<Coach> coaches,
    String name, String teamLevel, ArrayList<Division> divisions)
    {
        super(new ArrayList<Athlete>(roster), coaches, name, teamLevel, divisions);
    }
}