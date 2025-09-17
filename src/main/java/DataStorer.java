import MeetClasses.Meet;
import PeopleTypes.Athlete;
import PeopleTypes.Coach;
import PeopleTypes.Person;
import LiveResults.EventProformance;
import TeamTypes.Team;

import java.io.Serializable;
import java.util.ArrayList;

public class DataStorer implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private ArrayList<Athlete> athletes;
    private ArrayList<Team> teams;
    private ArrayList<Meet> meets;
    private ArrayList<Person> people;
    private ArrayList<Coach> coaches;
    private ArrayList<EventProformance> results;
    
    public DataStorer()
    {
        athletes = new ArrayList<>();
        teams = new ArrayList<>();
        meets = new ArrayList<>();
        people = new ArrayList<>();
        coaches = new ArrayList<>();
        results = new ArrayList<>();
    }

    public DataStorer(ArrayList<Athlete> athletes, ArrayList<Team> teams, ArrayList<Meet> meets, ArrayList<Person> people, ArrayList<Coach> coaches, ArrayList<EventProformance> results)
    {
        this.athletes = athletes;
        this.teams = teams;
        this.meets = meets;
        this.people = people;
        this.coaches = coaches;
        this.results = results;
    }

    public ArrayList<Athlete> getAthletes() {
        return athletes;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ArrayList<Meet> getMeets() {
        return meets;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public ArrayList<Coach> getCoaches() {
        return coaches;
    }

    public ArrayList<EventProformance> getResults() {
        return results;
    }

    public void listToTable()//puts java arraylist into an SQL table
    
    
}