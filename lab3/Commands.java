import java.io.BufferedReader;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.io.FileReader;

public class Commands {
    private static String currentDir = new String(System.getProperty("user.dir"));
    private static File wd = new File(currentDir);

    public static void exit(String[] cmd) {
        System.exit(0);
    }

    public static void pwd(String[] cmd) throws Exception {
        System.out.println(wd.getCanonicalPath());
    }

    public static void ls(String[] cmd) {
        File[] tmp = wd.listFiles();

        if(cmd.length > 1 && cmd[1].equals("-l")) {
            for(int i = 0; i < tmp.length; i++) {
                if(tmp[i].isDirectory()) System.out.println("d " + tmp[i].getName());
                if(tmp[i].isFile()) System.out.println("f " + tmp[i].getName());
            }    
            return;
        }
        
        for(int i = 0; i < tmp.length; i++) {
            System.out.println(tmp[i].getName());
        }
    }

    public static void cd(String[] cmd) throws Exception {
        
        if(cmd.length > 2) throw new Exception("cd: too many arguments");  //too many arguments exception
        if(cmd.length == 1) return; //if no arguments, than do nothing
        
        if(cmd[1].equals("..")) {
            wd = wd.getParentFile();
            return;
        }

        File file = new File(wd, cmd[1]);

        if(file.exists()) { 
            if(!file.isDirectory()) throw new Exception("cd: Not a directory");
                wd = file;
                return;
        }

        throw new Exception("cd: " + cmd[1] + ": Nu such file or directory"); //if the argument directory doeas not exist, throws Exception
    }

    public static void cat(String[] cmd) throws Exception {
        if(cmd.length > 2) throw new Exception("cat: too many arguments");
        if(cmd.length <= 1) throw new Exception("cat: lacking argmunets");

        File file = new File(wd, cmd[1]);

        if(file.exists()) { //if file exists, print content
            if(file.isDirectory()) throw new Exception("cat: Is a directory");
            FileReader fr = new FileReader(cmd[1]);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            while(line != null) {
                System.out.println(line);
                line = br.readLine();
            }
            return;
            
        }
        throw new Exception("cat: File does not exist in current directory"); //if file doeas not exist, throw Exception
    }

    public static void length(String[] cmd) throws Exception {
        if(cmd.length > 2) throw new Exception("length: too many arguments");
        if(cmd.length <= 1) throw new Exception("length: lacking argmunets");

        File file = new File(wd, cmd[1]);

        if(file.exists()) { //if file exists, print length
             if(file.isDirectory()) throw new Exception("cat: Is a directory");
            System.out.println(file.getTotalSpace() + " byte");
          
            return;
        }
        throw new Exception("cat: File does not exist in current directory"); //if file doeas not exist, throw Exception
    }
    
}
