package athleteTypes;

import java.util.*;
import java.io.*;
/*due to my lack of knowledge on decathalon scoring
 the score table and the equations for calculation 
those will be provided by nrich.maths.org/articles/decathlon-art-scoring-points*/

public class DecethaAthlete extends MultiEventAthlete implements Serializable{
    private static final long serialVersionUID = 1L;
    
public DecethaAthlete(String name, String userName, Team team, String gender, ArrayList<Result> results, ArrayList<EventProformance> attempts)
{
    //results at least stores prs for all 10 decathalon events
    //no Result in ArrayList Resullt should be noMark or null, if it is the only entry in that event.
    super(name, userName, team, gender, results, attempts);
}


public int getDecethalonScore()//also works to get Womens Heptathalon score
{
    
    //if(gender.equals("Male"))
    //{
    int points = 0;
    String[] events = {"100m", "long jump", "Shot Put", "High Jump", "400m", "110m Hurdles", "Discus Throw", "Pole Vault", "Javelin Throw", "1500m"};

    double[][] scoreTable = {
    {25.4347, 18.0,	1.81},
    {0.14354, 220.0, 1.4},
    {51.39,	1.5, 1.05},
    {0.8465, 75.0, 1.42},
    {1.53775, 82.0, 1.81},
    {5.74352, 28.5, 1.92},
    {12.91, 4.0, 1.1},
    {0.2797, 100.0,	1.35},
    {10.14,	7.0, 1.08},
    {0.03768, 480.0, 1.85}};

    for(int r = 0; r < events.length; r++)
    {
        if(r == 0 || r == 4 || r == 5 || r == 9)
        {
            points += getTrackEventScore(scoreTable[r][0], scoreTable[r][1], scoreTable[r][2], events[r]);
        }
        else
            points += getFieldEventScore(scoreTable[r][0], scoreTable[r][1], scoreTable[r][2], events[r]);
    }
    
    return points;
    //}
    
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