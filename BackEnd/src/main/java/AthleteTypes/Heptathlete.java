package AthleteTypes;

import LiveResults.EventProformance;
import LiveResults.Result;
import TeamTypes.OutdoorTeam;
import TeamTypes.Team;

import java.io.Serializable;
import java.util.ArrayList;

public class Heptathlete extends AllAthlete implements Serializable {
    private static final long serialVersionUID = 1L;

    public Heptathlete(String name, String userName, Team team, ArrayList<Result> results, ArrayList<EventProformance> attempts)
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

            double[][] scoreTable = {
                {9.23076, 26.7, 1.835},
                {1.84523, 75.0, 1.348},
                {56.0211, 1.5, 1.05},
                {4.99087, 42.5, 1.81},
                {0.188807, 210.0, 1.41},
                {15.9803, 3.8, 1.04},
                {0.11193, 254, 1.88}
            };
            for (int r = 0; r < events.length; r++) 
            {
                if (r == 0 || r == 3 || r == scoreTable.length) {
                    points += getTrackEventScore(scoreTable[r][0], scoreTable[r][1], scoreTable[r][2], events[r]);
                }
                else
                    points += getFieldEventScore(scoreTable[r][0], scoreTable[r][1], scoreTable[r][2], events[r]);
            }
        }
        else
        {

        }

        return points;
    }

    public int getFieldEventScore(double a, double b, double c, String event)
    {
     //returns the scoring of one field event
 
     //to add if event is not in meters, throw exception
     double d = results.get(results.indexOf(event)).getProformance();
     return (int)(a * Math.pow((d - b), c));
    }

    public int getTrackEventScore(double a, double b, double c, String event)
    {
        //returns the scoring of one track event
        double t = results.get(results.indexOf(event)).getProformance();
        return (int)(a * Math.pow((b - t), c));
    }
}
