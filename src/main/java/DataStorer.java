import java.util.*;
import java.io.*;

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