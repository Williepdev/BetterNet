package TeamTypes;

import LiveResults.Division;
import PeopleTypes.Athlete;
import PeopleTypes.Coach;
import PeopleTypes.Person;

import java.io.Serializable;
import java.util.ArrayList;
public abstract class Team implements Serializable{
    private static final long serialVersionUID = 1L;

    protected ArrayList<Athlete> roster;
    protected ArrayList<Coach> coaches;
    protected ArrayList<Person> teamMembers;
    protected String name;
    protected String teamLevel;//club, collegiate, 
    protected ArrayList<Division> divisions;//scc, class mm, etc
    
    public Team(ArrayList<Athlete> roster, ArrayList<Coach> coaches,
    String name, String teamLevel, ArrayList<Division> divisions)
    {
        this.roster = roster;
        this.coaches = coaches;
        this.name = name;
        this.teamLevel = teamLevel;
        this.divisions = divisions;
        teamMembers = new ArrayList<Person>();

        for(int i = 0; i < roster.size(); i++)
        {
            teamMembers.add(roster.get(i));
        }
        for(int i = 0; i < coaches.size(); i++)
        {
            teamMembers.add(coaches.get(i));
        }
    }
    
    public String getName()
    {
        return name;
    }
    
    public void addAthlete(Athlete a)
    {
        roster.add(a);
        teamMembers.add(a);
    }
    
    public void addCoach(Coach c)
    {
        coaches.add(c);
        teamMembers.add(c);
    }
    
    public ArrayList<Athlete> getRoster()
    {
        return roster;
    }


}