package PeopleTypes;

import java.util.*;
import java.io.*;

public class Coach extends Person implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Team team;
    private String specialty; //head, assistant, jumps, throws, distance
    
    public Coach(String name, String userName, String gender, Team team, String specialty)
    {
        super(name, userName, gender);
        this.team = team;
        team.addCoach(this);
        this.specialty = specialty;
    }
    
    public Coach(String name, String gender, Team team, String specialty)
    {
        super(name, gender);
        this.team = team;
        this.specialty = specialty;
    }
    
    public Coach(String name, String gender)
    {
        super(name, gender);
        team = null;
        specialty = "none";
    }
    
}