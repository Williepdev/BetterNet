import AthleteTypes.*;
import LiveResults.Division;
import PeopleTypes.Person;
import TeamTypes.CrossCountryTeam;
import TeamTypes.IndoorTeam;
import TeamTypes.OutdoorTeam;
import TeamTypes.Team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Team> teamList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DataStorer data = DataManager.load();
        System.out.println("Welcome to BetterNet, your alternative to Athletic.net!");
        mainMenu();
    }


    public static void mainMenu() {

            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to the Main Menu");
            System.out.println("1. Create");
            System.out.println("2. Load");
            System.out.println("3. Save");
            System.out.println("4. Exit");
            System.out.println("5. Credits");
            System.out.println("Please enter your choice: ");

            try {

                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        createMenu();
                    case 2:

                    case 3:

                    case 4:
                        break;
                    case 5:
                        printCredits();

                    default:
                        throw new IOException("That is not an option, try again");
                }
            }catch(Exception e) {
                System.out.println(e.getMessage());
                mainMenu();
            }

    }

    public static void createMenu()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Create Menu");
        System.out.println("1. Person");
        System.out.println("2. Team");
        System.out.println("3. Meet");
        System.out.println("4. Back to Main Menu");
        System.out.println("Enter your choice: ");
        try {
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    createPerson();
                case 2:
                    createTeam();
                case 3:
                    createMeet();
                case 4:
                    mainMenu();
                    default:
                    throw new IOException("That is not an option, try again");

            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
            createMenu();
        }
    }

    public static Team chooseTeam()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Select a Team.");
        for(int i = 0; i < teamList.size(); i++)
        {
            System.out.println((i+1) + ". " + teamList.get(i).getName());
        }
        int in = input.nextInt();
        return teamList.get(in - 1);

    }

    public static void createTeam()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the name of the team you want to create?");
        String teamName = input.nextLine();
        System.out.println("What level is your team? Ex) High School, Collegiate, etc");
        String teamLevel = input.nextLine();
        System.out.println("What divisions and leagues is your team in?(Separate by commas)");
        String divisions = input.nextLine();
        ArrayList<Division> divisionsList = divisionsToList(divisions);
        System.out.println("Is this a Cross Country, Indoor Track, or Outdoor Track Team? Type as written in the question");
        String teamType = input.nextLine();
        while (true) {
            try {
                switch (teamType) {
                    case "Cross Country":
                        teamList.add(new CrossCountryTeam(new ArrayList<>(), new ArrayList<>(), teamName, teamLevel, divisionsList));
                        break;
                    case "Indoor Track":
                        teamList.add(new IndoorTeam(new ArrayList<>(), new ArrayList<>(), teamName, teamLevel, divisionsList));
                        break;
                    case "Outdoor Track Team":
                        teamList.add(new OutdoorTeam(new ArrayList<>(), new ArrayList<>(), teamName, teamLevel, divisionsList));
                        break;
                    default:
                        throw new IOException("That is not an option please try again.");
                }
                break;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Team created successfully!, Now going back to main menu");
        mainMenu();
    }

    public static ArrayList<Division> divisionsToList(String str)
    {
        ArrayList<Division> divisions = new ArrayList<>();

        if(str.isEmpty())
        {
            return divisions;
        }

        if(str.indexOf(",") == -1 && !str.isEmpty())
        {
            divisions.add(new Division(str));
            return divisions;
        }

        divisions.add(new Division((str.substring(0, str.indexOf(",")))));
        return divisionsToList(str.substring(str.indexOf(",") + 1), divisions);
    }

    public static ArrayList<Division> divisionsToList(String str, ArrayList<Division> divisions)
    {

        if(str.isEmpty())
        {
            return divisions;
        }

        if(str.indexOf(",") == -1 && !str.isEmpty())
        {
            divisions.add(new Division(str));
            return divisions;
        }

        divisions.add(new Division(str.substring(0, str.indexOf(","))));
        return divisionsToList(str.substring(str.indexOf(",") + 1), divisions);

    }


    public static void createPerson()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Person Creation menu");
        System.out.println();
        if(!teamList.isEmpty()) {
            System.out.println("Please enter full name: ");
            String name = input.nextLine();
            System.out.println("What is your gender");
            String gender = input.nextLine();
            System.out.println("Create a userName");
            String userName = input.nextLine();
            if (userName.isEmpty()) {
                userName = name;
            }
            System.out.println("Choose a team for this person");
            Team team = chooseTeam();
            System.out.println("Is the Person a Coach or an Athlete?");
            try {
                String option = input.nextLine();
                switch (option) {
                    case "Coach":

                    case "Athlete":
                        createAthlete(name, gender, userName, team);
                    default:
                        throw new IOException("That is not an option, try again please");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                createPerson();
            }
        }
        else
        {
            System.out.println("You must create a team before you create a Person.");
            System.out.println();
            mainMenu();
        }

    }

    public static void createAthlete(String name, String gender, String userName, Team team)
    {
        Scanner  input = new Scanner(System.in);
        System.out.println("Welcome to the Athlete Creation menu");
        System.out.println("What kind of Athlete you want to create?");
        System.out.println("1. MultiEventAthlete");
        System.out.println("2. Distance Runner");
        System.out.println("3. Runner");
        System.out.println("4. Thrower");
        System.out.println("5. Jumper");
        System.out.println("6. Decathlete");
        System.out.println("7. Heptathlete");


        System.out.println("Enter your choice: ");
        try {
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    Person a = new MultiEventAthlete(name, userName, team, gender, new ArrayList<>(), new ArrayList<>());
                case 2:
                    Person b = new DistanceRunner(name, userName, team, gender, new ArrayList<>(), new ArrayList<>());
                case 3:
                    Person c = new Runner(name,  userName, team, gender, new ArrayList<>(), new ArrayList<>());
                case 4:
                    Person d = new Thrower(name, userName, team, gender, new ArrayList<>(), new ArrayList<>());
                case 5:
                    Person e = new Jumper(name, userName, team, gender, new ArrayList<>(), new ArrayList<>());
                case 6:
                    Person f = new DecethaAthlete(name, userName, team, new ArrayList<>(), new ArrayList<>());
                case 7:

                default:
                    throw new IOException("That is not an option, try again please");
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            createAthlete(name, gender, userName, team);
        }
    }

    public static void createMeet()
    {
        Scanner input = new Scanner(System.in);

    }



    public static void printCredits()
    {
        System.out.println("Thank you for using this platform");
        System.out.println();
        
        System.out.println("Insperation from Athletic.net and from the Joe Kovacs podcast for the idea");
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        System.out.println("CLI made by Willie Pirri");
        System.out.println("Classes made by Willie Pirri");
        System.out.println("Backend made by Willie Pirri");
        System.out.println("Class Structure by Willie Pirri");
        System.out.println("Written by Willie Pirri");
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        System.out.println("Special thanks to my coaches: Coach Norton, Coach P, Coach Diggs, and Coach Nemec, and  Coach Country, for always pushing me in and out of the circle");
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
