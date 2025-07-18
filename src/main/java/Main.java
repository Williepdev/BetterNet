import AthleteTypes.*;
import EventTypes.Event;
import EventTypes.FieldEvents.JumpEvents.HorizontalJump;
import EventTypes.FieldEvents.JumpEvents.VerticalJump;
import EventTypes.FieldEvents.ThrowEvent;
import EventTypes.TrackEvent;
import MeetClasses.Meet;
import TeamTypes.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Main
{
        public static void main (String[]args){
            Scanner input = new Scanner(System.in);
            ArrayList<Team> teams = new ArrayList<>();
            ArrayList<Event> events = new ArrayList<>();
            ArrayList<Meet> meets = new ArrayList<>();

            System.out.println("Welcome to BetterNet, your alternative to Athletic.net!");

            boolean running = true;
            while (running) {
                System.out.println("\nMain Menu:");
                System.out.println("1. Create Team");
                System.out.println("2. Create Athlete");
                System.out.println("3. Create Event");
                System.out.println("4. Create Meet");
                System.out.println("5. View Data");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                String choice = input.nextLine();

                switch (choice) {
                    case "1":
                        teams.add(createTeam(input));
                        break;
                    case "2":
                        createAthlete(input, teams);
                        break;
                    case "3":
                        events.add(createEvent(input));
                        break;
                    case "4":
                        meets.add(createMeet(input, teams, events));
                        break;
                    case "5":
                        viewData(teams, events, meets);
                        break;
                    case "6":
                        running = false;
                        System.out.println("Exiting... Thank you for using BetterNet!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }


    public static void createFile(File myFile)
    {
        try
        {
            if(myFile.createNewFile())
            {
                System.out.println("File Created: " + myFile.getName());
            }
            else
                System.out.println("File already exists");
        }
        catch(IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

    public static void printFile(File myFile)
    {
        try
        {
            Scanner reader = new Scanner(myFile);
            while(reader.hasNextLine())//while there is a next line in the file
            {
                String data = reader.nextLine();
                System.out.println(data);
            }

        reader.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private static Team createTeam(Scanner input)
    {
        System.out.print("Enter team name: ");
        String name = input.nextLine();
        System.out.print("Enter team level (e.g., High School, Collegiate): ");
        String level = input.nextLine();
        System.out.print("Enter team divisions (comma-separated): ");
        String divisionsInput = input.nextLine();
        ArrayList<String> divisions = new ArrayList<>();
        for (String division : divisionsInput.split(",")) {
            divisions.add(division.trim());
        }

        System.out.println("Select team type:");
        System.out.println("1. Outdoor Team");
        System.out.println("2. Indoor Team");
        System.out.println("3. Cross Country Team");
        System.out.print("Enter your choice: ");
        String type = input.nextLine();

        switch (type)
        {
            case "1":
                return new OutdoorTeam(new ArrayList<>(), new ArrayList<>(), name, level, divisions);
            case "2":
                return new IndoorTeam(new ArrayList<>(), new ArrayList<>(), name, level, divisions);
            case "3":
                return new CrossCountryTeam(new ArrayList<>(), new ArrayList<>(), name, level, divisions);
            default:
                System.out.println("Invalid team type. Team not created.");
                return null;
        }
    }

    private static void createAthlete(Scanner input, ArrayList<Team> teams)
    {
        if (teams.isEmpty())
        {
            System.out.println("No teams available. Create a team first.");
            return;
        }

        System.out.println("\nSelect Athlete Type:");
        System.out.println("1. MultiEventAthlete");
        System.out.println("2. DecethaAthlete");
        System.out.println("3. Jumper");
        System.out.println("4. Runner");
        System.out.println("5. Thrower");
        System.out.println("6. DistanceRunner");
        System.out.print("Enter your choice: ");
        String choice = input.nextLine();

        System.out.print("Enter athlete name: ");
        String name = input.nextLine();
        System.out.print("Enter athlete username: ");
        String username = input.nextLine();
        System.out.print("Enter athlete gender (Male/Female): ");
        String gender = input.nextLine();

        System.out.println("Select a team for the athlete:");
        for (int i = 0; i < teams.size(); i++)
        {
            System.out.println((i + 1) + ". " + teams.get(i).getName());
        }
        System.out.print("Enter your choice: ");
        int teamIndex = Integer.parseInt(input.nextLine()) - 1;
        Team team = teams.get(teamIndex);

        switch (choice)
        {
            case "1":
                team.addAthlete(new MultiEventAthlete(name, username, team, gender, new ArrayList<>(), new ArrayList<>()));
                break;
            case "2":
                team.addAthlete(new DecethaAthlete(name, username, team, gender, new ArrayList<>(), new ArrayList<>()));
                break;
            case "3":
                team.addAthlete(new Jumper(name, username, team, gender, new ArrayList<>(), new ArrayList<>()));
                break;
            case "4":
                team.addAthlete(new Runner(name, username, team, gender, new ArrayList<>(), new ArrayList<>()));
                break;
            case "5":
                team.addAthlete(new Thrower(name, username, (TrackTeam) team, gender, new ArrayList<>(), new ArrayList<>()));
                break;
            case "6":
                team.addAthlete(new DistanceRunner(name, username, team, gender, new ArrayList<>(), new ArrayList<>()));
                break;
            default:
                System.out.println("Invalid choice. Athlete not created.");
        }
    }

    private static Event createEvent(Scanner input)
    {
        System.out.println("\nSelect Event Type:");
        System.out.println("1. Track Event");
        System.out.println("2. Throw Event");
        System.out.println("3. Horizontal Jump");
        System.out.println("4. Vertical Jump");
        System.out.print("Enter your choice: ");
        String choice = input.nextLine();

        System.out.print("Enter event name: ");
        String name = input.nextLine();
        System.out.print("Enter event gender (Male/Female): ");
        String gender = input.nextLine();
        System.out.print("Enter event units (e.g., Seconds, Meters): ");
        String units = input.nextLine();

        switch (choice)
        {
            case "1":
                return new TrackEvent(name, gender, units, new ArrayList<>(), 100);
            case "2":
                return new ThrowEvent(name, gender, units, new ArrayList<>(), 3);
            case "3":
                return new HorizontalJump(name, gender, units, new ArrayList<>(), 3);
            case "4":
                return new VerticalJump(name, gender, units, new ArrayList<>(), 3, 1.5);
            default:
                System.out.println("Invalid choice. Event not created.");
                return null;
        }
    }

    private static Meet createMeet(Scanner input, ArrayList<Team> teams, ArrayList<Event> events)
    {
        if (teams.isEmpty() || events.isEmpty()) {
            System.out.println("No teams or events available. Create them first.");
            return null;
        }

        System.out.print("Enter meet name: ");
        String name = input.nextLine();
        System.out.print("Enter meet location: ");
        String location = input.nextLine();
        System.out.print("Enter meet type (INVITE/DUEL/TRI): ");
        String type = input.nextLine();

        ArrayList<Team> selectedTeams = new ArrayList<>();
        System.out.println("Select teams for the meet (comma-separated indices):");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println((i + 1) + ". " + teams.get(i).getName());
        }
        String[] teamIndices = input.nextLine().split(",");
        for (String index : teamIndices) {
            selectedTeams.add(teams.get(Integer.parseInt(index.trim()) - 1));
        }

        ArrayList<Event> selectedEvents = new ArrayList<>();
        System.out.println("Select events for the meet (comma-separated indices):");
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". " + events.get(i).getName());
        }
        String[] eventIndices = input.nextLine().split(",");
        for (String index : eventIndices) {
            selectedEvents.add(events.get(Integer.parseInt(index.trim()) - 1));
        }

        return new Meet(name, location, new Date(), selectedTeams, selectedEvents, type);
    }

    private static void viewData(ArrayList<Team> teams, ArrayList<Event> events, ArrayList<Meet> meets)
    {
        System.out.println("\nTeams:");
        for (Team team : teams) {
            System.out.println("- " + team.getName());
        }

        System.out.println("\nEvents:");
        for (Event event : events) {
            System.out.println("- " + event.getName());
        }

        System.out.println("\nMeets:");
        for (Meet meet : meets) {
            System.out.println("- " + meet);
        }
    }

    public static void printCredits()
    {
        System.out.println("Thank you for using this platform");
        System.out.println();
        
        System.out.println("Insperation from Athletic.net and from the Joe Kovacs podcast for the idea");
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        System.out.println("UI made by Willie Pirri");
        System.out.println("Classes made by Willie Pirri");
        System.out.println("Backend made by Willie Pirri");
        System.out.println("Class Structure by Willie Pirri");
        System.out.println("Written by Willie Pirri");
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        System.out.println("Special thanks to my coaches: Coach Norton, Coach P, Coach Diggs, and Coach Nemec, and other Coaches like Coach Country");
        System.out.println("Special thanks to my friends for feedback on both this project and Athletic.net");
        System.out.println("Special thanks to my teammates for complaining so much I had something to fix");
        System.out.println("Special thanks to my Mom as well for complaining so much I had to fix it");
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        System.out.println("Work Cited");
        System.out.println("Decathalon scoring chart from nrich.maths.org");
        System.out.println("Duel/Tri meet scoring from https://sportmentary.com/track-field/track-field-basics/keep-score-track-field-meet/");
        System.out.println("Invintation scoring from  & https://centralconnecticutconference.org/ccc-regulations-indoor-track-g/");
        System.out.println("Most Of the Things For DataManager and DataStorer were not done by me but used from forums and videos as I was cramming hard and the way I intended to go about this would not work well with my class structure");
    }
}
