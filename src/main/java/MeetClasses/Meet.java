package MeetClasses;

import EventTypes.Event;
import EventTypes.Relay;
import PeopleTypes.Athlete;
import LiveResults.EventProformance;
import LiveResults.Result;
import TeamTypes.Team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
//imports date and time
//scoring site https://sportmentary.com/track-field/track-field-basics/keep-score-track-field-meet/ & https://centralconnecticutconference.org/ccc-regulations-indoor-track-g/
/*I do not know how to score pole vault/High jump 
nor would want to learn right now of how that would be
extremely hard to deal with therefore incase of a tie
both will recieve same number of points
*/
public class Meet implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Date date;//initialized as Date(y, m, d)
    private ArrayList<Event> events;
    private ArrayList<Team> teams;
    private String name;
    private String location;
    private String type;// has to be Initialized as INVITE OR DUEL/TRI

    
    public Meet(String name, String location, Date date, ArrayList<Team> teams,
    ArrayList<Event> events, String type)
    {
        this.name = name;
        this.location = location;
        this.date = date;
        this.teams = teams;
        this.events = events;
        
        if(!(type.equals("INVITE") || type.equals("DUEL/TRI")))
        {
            throw new IllegalArgumentException("Meet type invalid. Types Must be 'INVITE' or 'DUEL/TRi' this is crutial for the working of this software");   
        }
        else
            this.type = type;
    }
    
    public int getTeamScore(Team team)
    {
        int totalPoints = 0;
        for(Event e : events)//traverses through the meets events
        {
            if(e.getResults() != null)//if event has finished
            {
                ArrayList<Result> results = e.getFinalStandings();
                
                if(type.equals("DUEL/TRI"))
                {
                    if(!(e instanceof Relay))
                    {
                        if(results.get(results.size() - 1).getAthlete().getTeam().equals(team))
                        {
                            totalPoints += 5;
                        }
                        else if(results.get(results.size() - 2).getAthlete().getTeam().equals(team))
                        {
                            totalPoints += 3;
                        }
                        else if(results.get(results.size() - 3).getAthlete().getTeam().equals(team))
                        {
                            totalPoints += 1;
                        }
                    }
                    else
                    {
                        if(results.get(results.size() - 1).getAthlete().getTeam().equals(team))
                        {
                            totalPoints += 5;
                        }
                    }
                }
                else
                {
                        if(results.get(results.size() - 1).getAthlete().getTeam().equals(team))
                        {
                            totalPoints += 10;
                        }
                        else if(results.get(results.size() - 2).getAthlete().getTeam().equals(team))
                        {
                            totalPoints += 8;
                        }
                        else if(results.get(results.size() - 3).getAthlete().getTeam().equals(team))
                        {
                            totalPoints += 6;
                        }
                        else if(results.get(results.size() - 4).getAthlete().getTeam().equals(team))
                        {
                            totalPoints += 5;
                        }
                        else if(results.get(results.size() - 5).getAthlete().getTeam().equals(team))
                        {
                            totalPoints += 6;
                        }
                        else if(results.get(results.size() - 6).getAthlete().getTeam().equals(team))
                        {
                            totalPoints += 4;
                        }
                        else if(results.get(results.size() - 7).getAthlete().getTeam().equals(team))
                        {
                            totalPoints += 3;
                        }
                        else if(results.get(results.size() - 8).getAthlete().getTeam().equals(team))
                        {
                            totalPoints += 2;
                        }
                        else if(results.get(results.size() - 9).getAthlete().getTeam().equals(team))
                        {
                            totalPoints += 1;
                        }
                }
            }
        }
        
        return totalPoints;
    }
    

    
    private void sortTeamsByPoints()
    {
        for (int i = 0; i < teams.size() - 1; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < teams.size(); j++)
            {
                if(getTeamScore(teams.get(j)) >= getTeamScore(teams.get(minIndex)))
                {
                    minIndex = j;
                }
            }
            // Swap entries
            Team temp = teams.get(i);
            teams.set(i, teams.get(minIndex));
            teams.set(minIndex, temp);
        }
    }
    
    public ArrayList<EventProformance> getAthleteComp(Athlete athlete)
    {
        ArrayList<EventProformance> temp = new ArrayList<>();
        for(EventProformance e : athlete.getProformances())
        {
            if(e.getAthlete().equals(athlete))
            {
                temp.add(e);
            }
        }
        
        return temp;
    }
    
    public ArrayList<Result> getEventResults(Event event)
    {
        ArrayList<Result> leaderBoard = new ArrayList<>();
        
            for(EventProformance p : event.getResults().getResults())
            {
                if(p.getEvent().equals(event))
                {
                    //gets best result from that proformance
                    leaderBoard.add(p.getBestTrial());
                }
            }
        
        
        return leaderBoard;
    }
    
    public String toString()
    {
        sortTeamsByPoints();
        
        String temp = "";
        int i = 0;
        for(Team t : teams)
        {
            i++;
            temp += t.getName() + " has " + getTeamScore(t) + " points and came in " + i + " Place \n";
        }
        
        return name + " at " + location + " on " + date + ". These are the final results " + temp;
    }
}