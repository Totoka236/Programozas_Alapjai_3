package lab4;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String input;
        String[] cmd;
        
        

        while(true) {
             System.out.print("> ");
            input = scanner.nextLine(); //read next line
            cmd = input.split(" ");

            //System.out.println(cmd[0] + cmd.length);

            try{
            
                if(cmd[0].equals("exit")) { //if commmand is "exit" than stop vm
                    beerList.exit(cmd);
                    break;
                }

                if(cmd[0].equals("add")) {//if command is "add" than add new beer to beers
                    beerList.add(cmd);
                }
                
                if(cmd[0].equals("list")) { //if command is "list" than list all beers in the list
                    beerList.list(cmd);
                }

                if(cmd[0].equals("load")) { //if command is "load" than load beerlist from given file
                    beerList.load(cmd);
                }

                if(cmd[0].equals("save")) { //if command is "save" than saves beerlist to file specified
                    beerList.save(cmd);
                }
            } catch(Exception e) {System.out.println(e.getMessage());}
        }
    }
    
}
