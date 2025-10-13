import java.util.Scanner;
import java.io.File;

public class Main {

     
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input;
        String[] cmd;
       
        while(true) {
            System.out.print(">");
            input = scanner.nextLine();
            cmd = input.split(" "); //get input line every cycle
           

            try{

                if(cmd[0].equals("exit")) { //check if command is "exit"
                    Commands.exit(cmd);
                    break; //not essential
                }

                if(cmd[0].equals("pwd")) { //check if command is "pwd"
                    Commands.pwd(cmd);
                }

                if(cmd[0].equals("ls")) { //check if command is "ls"
                    Commands.ls(cmd);
                }

                if(cmd[0].equals("cd")) { //check if command is "cd"
                    Commands.cd(cmd);
                }

                if(cmd[0].equals("cat")) { //check if command is "cat"
                    Commands.cat(cmd);
                }

                if(cmd[0].equals("length")) { //check if command is "length"
                    Commands.length(cmd);
                }
        } catch(Exception e) { System.out.println(e.getMessage()); }
        }

    }
}