
import java.util.Scanner;
import java.lang.Boolean;

public class elso {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nAdj meg egy számot: ");

        //1a
        int szam = scanner.nextInt();

        if(tokeletes(szam))
            System.out.print("\nTokeletes a szam!");
        else
            System.out.print("\nNem tokeletes a szam! :(");
        //1at vege
        
        //1b feladat
        System.out.println("\nTokeletes szamok a megadott szam kozott:");
        for(int i = 1; i < szam; i++ )
            if(tokeletes(i)){
                System.out.print(i); System.out.print(" ");
            }
        //1b vege
                
    }

    public static Boolean tokeletes(int szam){
            int osztokOsszege = 0;

            for(int i = 1; i <= szam/2; i++){
                if(szam % i == 0)
                    osztokOsszege += i;
            }

            return osztokOsszege == szam;  
        
        }
    
}