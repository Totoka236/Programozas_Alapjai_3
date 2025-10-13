package masodik;
import java.util.Scanner;
public class masodik {
    public static void main(String[] args){
        //2a
        System.out.print("\n\nAdjon meg ket szamot: ");
        Scanner scanner = new Scanner(System.in);
        int elso = scanner.nextInt();
        int masodik = scanner.nextInt();
        
        if(baratsagos(elso, masodik))
            System.out.print("Baratsagosak!");
        else
            System.out.print("Nem baratsagosak!");
        //2a vege!

        //2b
        System.out.print("\nAdjon meg egy szamot: ");
        int szam = scanner.nextInt();

        for(int i = 1; i < szam; i++) {
            for(int j = 1; j < szam; j++)  {
                if(baratsagos(i, j) && i != j)
                    System.out.print(i + "-" + j + "\n");
            }
            
        }
        //2b vege
    }


    public static boolean baratsagos(int elso, int masodik){
        int osszegElso = 0;
        int osszegMasodik = 0;

        for(int i = 1; i <= elso/2; i++)
            if(elso % i == 0)
                osszegElso += i;

        for(int i = 1; i <= masodik/2; i++)
            if(masodik % i == 0)
                osszegMasodik += i;

        return osszegElso == masodik && osszegMasodik == elso;        
    }
}
