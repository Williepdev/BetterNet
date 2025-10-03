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
    
     ArrayList<Athlete> athletes;
     ArrayList<Team> teams;
     ArrayList<Meet> meets;
     ArrayList<Person> people;
     ArrayList<Coach> coaches;
     ArrayList<EventProformance> results;
    
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

    public void addPerson(Person person)
    {
        people.add(person);
    }

    public void addTeam(Team team)
    {
        teams.add(team);
    }

    public void addMeet(Meet meet)
    {
        meets.add(meet);
    }


    public void listToTable(){
        //puts java arraylist into an SQL table
        
    }


    public String toString() {
        String string = "";

        for(Person p : people)
        {
            string += p.toString() + "\n";
        }

        for(Team t : teams)
        {
            string += t.toString() + "\n";
        }

        for(Meet m : meets)
        {
            string += m.toString() + "\n";
        }

        return string;
    }
}