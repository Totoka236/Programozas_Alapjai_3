import java.util.Random;

public class Asztal {
    
    public void ujJatek() {
        tet = 0;
        kor = 0;
        
        Random random = new Random();
        goal = random.nextDouble() * 100;

    }

    public void addJatekos(Jatekos j) {
        if(jatekosok.length >= 10) {
            System.out.println("Ez az asztal mar megtelet!");
            return;
        }

        Jatekos temp[] = new Jatekos[jatekosok.length + 1];

        for(int i = 0; i < jatekosok.length; i++) {
            temp[i] = jatekosok[i];
        }

        temp[jatekosok.length] = j;

        jatekosok = new Jatekos[jatekosok.length + 1];
        jatekosok = temp;

        if(jatekosok.length >= 10) {
            System.out.println("Ez az asztal eppen megtelet!");
        }

        j.setAsztal(this);

    }

    public int getKor() { return kor; }

    public void emel(double d) { tet += d; }

    public void kor() {

        if((tet > goal + goal * 0.1) || (tet <= goal + goal * 0.1 && tet >= goal)) {
            System.out.println("Vege a jateknak!");
        }

        kor++;

        for(int  i = 0; i < jatekosok.length; i++) {
            jatekosok[i].lep();
            if(tet <= goal + goal * 0.1 && tet >= goal) {
                System.out.println("A " + i + " sorszamu jatekos nyert!");
                return;
            }

            if(tet > goal + goal * 0.1) {
                System.out.println("Mindenki veszitette!");
            }
        }

        System.out.println("A tet aktualis erteke: " + tet);
    }

    public double getTet() { return tet; }
    
    private Jatekos jatekosok[] = new Jatekos[0];
    private double tet;
    private int kor;
    private double goal;
}