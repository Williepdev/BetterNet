package AthleteTypes;

import LiveResults.EventProformance;
import LiveResults.Result;
import TeamTypes.OutdoorTeam;
import TeamTypes.Team;

import java.io.Serializable;
import java.util.ArrayList;

public class Heptathathlete extends AllAthlete implements Serializable {
    private static final long serialVersionUID = 1L;

    public Heptathathlete(String name, String userName, Team team, ArrayList<Result> results, ArrayList<EventProformance> attempts)
    {
        //results at least stores prs for all 10 decathalon events
        //no Result in ArrayList Resullt should be noMark or null, if it is the only entry in that event.
        super(name, userName, team, "Female", results, attempts);
    }

    @Override
    public int calculateScore()
    {
        int points = 0;
        if(team instanceof OutdoorTeam)
        {
            String[] events = {"100m hurdles", "High Jump", "Shot Put", "200m", "Long Jump", "Javelin Throw", "800m"};

            double[][] scoringTable
        }
        else
        {

        }

        return points;
    }
}
