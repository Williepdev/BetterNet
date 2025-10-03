package TeamTypes;

import LiveResults.Division;
import PeopleTypes.Athlete;
import PeopleTypes.Coach;

import java.io.Serializable;
import java.util.ArrayList;
public class OutdoorTeam extends TrackTeam implements Serializable{
    private static final long serialVersionUID = 1L;

    public OutdoorTeam(ArrayList<Athlete> roster, ArrayList<Coach> coaches,
                       String name, String teamLevel, ArrayList<Division> divisions)
    {
        super(roster, coaches, name, teamLevel, divisions);
    }
}