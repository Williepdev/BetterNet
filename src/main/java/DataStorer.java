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
    
    
}