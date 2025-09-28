import java.io.*;

public class DataManager {

    private static final String FILE_NAME = "C:\\Users\\willi\\Documents\\BetterNet\\src\\main\\resources\\data.ser";

    public static void save(DataStorer store) throws IOException {
            FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(store);
            out.close();
            fileOut.close();
    }
    
    
    public static DataStorer load() throws IOException, ClassNotFoundException {

        DataStorer store = null;

        FileInputStream fileIn = new FileInputStream(FILE_NAME);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        store = (DataStorer) in.readObject();
        in.close();
        fileIn.close();
        return store;
    }

}