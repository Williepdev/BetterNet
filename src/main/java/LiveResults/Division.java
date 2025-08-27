package LiveResults;

import TeamTypes.Team;

import java.io.Serializable;
import java.util.ArrayList;

public class Division implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private ArrayList<Team> teams;

    public Division(String name) {
        this.name = name;
        this.teams = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }
}
