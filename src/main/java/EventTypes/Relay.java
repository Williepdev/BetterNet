package EventTypes;

import java.util.*;
import java.io.*;

public class Relay extends TrackEvent implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private ArrayList<Athlete> relayTeam;//Athletes of the same team in order
    private int firstLeg;//distance of leg
    private int secondLeg;
    private int thirdLeg;
    private int fourthLeg;
    
    public Relay(String name, String gender, String unitType, ArrayList<Heat> heats, int distance,
    ArrayList<Athlete> relayTeam, int firstLeg, int secondLeg, int thirdLeg, int fourthLeg)
    {
        //unit type secs/minutes
        super(name, gender, unitType, heats, distance);
        this.numOfHeats = heats.size();
        
        this.relayTeam = relayTeam;
        this.firstLeg = firstLeg;
        this.secondLeg = secondLeg;
        this.thirdLeg = thirdLeg;
        this.fourthLeg = fourthLeg;
    }
    
    public void printLeg(int leg)
    {
        ArrayList<Integer> legs = new ArrayList<>();
        legs.add(firstLeg);
        legs.add(secondLeg);
        legs.add(thirdLeg);
        legs.add(fourthLeg);
        System.out.println(relayTeam.get(leg) + " is the " + leg + " leg, and is running " + legs.get(leg - 1) + " meters");
    }
}