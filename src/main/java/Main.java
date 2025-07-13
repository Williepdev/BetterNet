import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
        DataStorer data = DataManager.load();
        Scanner input = new Scanner(System.in);
        File myFile = new File("test.txt");
        
        ArrayList<String> divisions = new ArrayList<>();
        divisions.add("Class MM");
        divisions.add("CIAC");
        divisions.add("SCC");
        
        Team guilford = new OutdoorTeam(new ArrayList<Athlete>(), new ArrayList<Coach>(), "Guilford Track & Field", "High School", divisions);
        Athlete ethan = new DecethaAthlete("Ethan wineKamp", "EWinekamp", guilford, "Male", new ArrayList<Result>(), new ArrayList<EventProformance>());//using someone off team to show an example, sorry just really easy to
        Event onehundredmeter = new TrackEvent("100M", "Male", "Seconds", new ArrayList<Heat>(), 100);
        ethan.addResult(new Result(ethan, onehundredmeter, 11.28, "Completed", "N/A"));
        printCredits();
        
        //run();
        DataManager.save(data);
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
    /*
    public static void run()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to BetterNet, your Java Better Alternative to Athletic.net the website your sport relies on that never works");
        boolean in = true;
        while(in)
        {
            System.out.println("If you would like to create data, Type in NEW, If you have prexisting data and would like to search, Type SEARCH");
            String newOrSearch = input.nextLine();
            
            if(newOrSearch.equals("NEW"))
            {
                System.out.println("first in order to make anything work you must create a team");
                System.out.println("What would you like to call this team");
                String teamName = input.nextLine();
                System.out.println("What is the teams level? Ex) Club, Collegiate, High School");
                String teamLevel = input.nextLine();
                System.out.println("What are the teams divisions? Format like this: SCC, CIAC, ClASS MM, etc");
                String divisions = input.nextLine();
                ArrayList<String> division = new ArrayList<>();
                for(int i = 0; i < divisions.length(); i++)
                {
                    String temp = "";
                    
                    temp = divisions.substring(0, divisions.indexof(","));
                    division.add(temp);
                    
                    divisions = divisions.substring(divisions.indexof(",") + 1);
                }
                
                
                
                String type = input.nextLine();
                if(type.equals("Athlete"))
                {
                    System.out.println("1. MultiEventAthlete\n 2. DecethAthlete\n 3. Jumper\n 4. Runner\n 5. Thrower\n 6. DistanceRunner");
                    String athleteType = input.nextLine();
                    if(athleteType.equals("MultiEventAthlete"))
                    {
                        System.out.println("What is The Name of This Athlete");
                        String name = input.nextLine();
                        System.out.println("What is The UserName of This Athlete");
                        String userName = input.nextLine();
                        System.out.println("What is The Athletes gender, MALE OR FEMALE");
                        String gender = input.nextLine();
                        System.out.println("What is this athletes teams name");
                        String teamName = input.nextLine();
                        System.out.println("What is the ");
                    }
                }
            }
            else if(newOrSearch.equals("SEARCH"))
            {
                System.out.println("Type the name of the file you would like to search for");
                String fileName = input.nextLine();
                //to Implement later
            }
            else
                throw new IllegalArgumentException("Error Invalid type");
        }
        printCredits();
        
    }
    */
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