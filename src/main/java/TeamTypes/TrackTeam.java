package TeamTypes;

import LiveResults.Division;
import PeopleTypes.Athlete;
import PeopleTypes.Coach;

import java.io.Serializable;
import java.util.ArrayList;
public abstract class TrackTeam extends Team implements Serializable{
    private static final long serialVersionUID = 1L;

    public TrackTeam(ArrayList<Athlete> roster, ArrayList<Coach> coaches,
                     String name, String teamLevel, ArrayList<Division> divisions)
    {
        super(roster, coaches, name, teamLevel, divisions);
    }

}