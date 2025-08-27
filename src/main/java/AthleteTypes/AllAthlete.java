package AthleteTypes;

import LiveResults.EventProformance;
import LiveResults.Result;
import TeamTypes.Team;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class AllAthlete extends MultiEventAthlete implements Serializable{
    private static final long serialVersionUID = 1L;

    public AllAthlete(String name, String userName, Team team, String gender, ArrayList<Result> results, ArrayList<EventProformance> attempts) {
        super(name, userName, team, gender, results, attempts);
    }

    public abstract int calculateScore();

}