package lab4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class beerList {
    
    static ArrayList<Beer> beers = new ArrayList<>();

    public static void exit(String[] cmd) {
        System.exit(0);
    }

    public static void add(String[] cmd) throws Exception {
        if(cmd.length > 4) throw new Exception("add: too many arguments");
        if(cmd.length < 4) throw new Exception("add: lack of arguments");


        beers.add(new Beer(cmd[1], cmd[2], Double.parseDouble(cmd[3])));

        System.out.println("New beer added!");
    }

    public static void list(String[] cmd) {
        if(beers.size() == 0) {
            System.out.println("No beers in the list!");
            return;
        }

        for(Beer beer : beers) {
            System.out.println(beer.toString());
        }
    }

    public static void load(String[] cmd) throws Exception {
        if(cmd.length > 2) throw new IllegalArgumentException("load: too many arguments");
        if(cmd.length < 2) throw new IllegalArgumentException("load: lack of arguments");

        File file = new File(cmd[1]);
        if(!file.exists()) throw new FileNotFoundException("File does not exist!");

        FileInputStream fs = new FileInputStream(file);
        ObjectInputStream os = new ObjectInputStream(fs);

        beers = (ArrayList<Beer>) os.readObject();
        os.close();
        fs.close();
    }

    public static void save(String[] cmd) throws Exception {
        if(cmd.length > 2) throw new IllegalArgumentException("save: too many arguments");
        if(cmd.length < 2) throw new IllegalArgumentException("save: lack of arguments");

        File file = new File(cmd[1]);

        if(!file.exists()) file.createNewFile();

        FileOutputStream fs = new FileOutputStream(file);
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(beers);
        os.close();

    }
}
