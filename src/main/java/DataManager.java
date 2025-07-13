import java.io.*;

public class DataManager {

    private static final String FILE_NAME = "data.ser";
    
    public static void save(DataStorer store)
    {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
            out.writeObject(store);
        } catch(IOException e){
            System.out.println("Error saving data: " + e.getMessage());   
        }
    }
    
    public static DataStorer load(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))){
            return (DataStorer) in.readObject();
        } catch(IOException | ClassNotFoundException e){
            System.out.println("No saved data found. Starting fresh");
            return new DataStorer();
        }
    }

}