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
import java.util.Collection;
import java.util.Collections;

public class BeerList {
    
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

    public static void list(String[] cmd) throws Exception { //TODO list does not work alonelisd
        if(cmd.length > 2) throw new Exception("list: too many arguments");

        if(beers.size() == 0) {
            System.out.println("No beers in the list!");
            return;
        }

        ArrayList<Beer> tmp = (ArrayList<Beer>) beers.clone(); 
        
        if(cmd[1].equals("name")) {
           
            Collections.sort(tmp, new NameComparator());
        }

        if(cmd[1].equals("style")) {
           
            Collections.sort(tmp, new StyleComparator());
        }

        if(cmd[1].equals("stregth")) {
           
            Collections.sort(tmp, new StrengthComparator());
        }

        for(Beer beer : tmp) {
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

    public static void search(String[] cmd) throws Exception {
        if(cmd.length > 2) throw new IllegalArgumentException("search: too many arguments");
        for(Beer beer : beers) {
            if(cmd[1].equals(beer.getName()))
                System.out.println(beer.toString());
        }
    }

    public static void find(String[] cmd) throws Exception { //TODO does not work properly
        if(cmd.length > 2) throw new IllegalArgumentException("find: too many arguments");

        for(Beer beer : beers) {
            if(cmd[1].contains(beer.getName()))
                System.out.println(beer.toString());
        }
    }
}
