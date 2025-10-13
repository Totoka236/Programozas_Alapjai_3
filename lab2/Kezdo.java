public class Kezdo extends Jatekos {
    Kezdo(String s) { nev = s; }

    public void lep() {
        System.out.println(toString());
        System.out.println("Jelenlegi kor: " + asztal.getKor());

        if(asztal.getKor() % 2 == 0) {
            asztal.emel(1.0);
        }
    }

    public String toString() { return nev; }
    
    private String nev;
}
