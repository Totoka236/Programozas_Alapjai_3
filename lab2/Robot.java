public class Robot extends Jatekos{

    public void lep() {
        System.out.println(toString());
        System.out.println("Jelenlegi kor: " + asztal.getKor());
    }

    public String toString() { return "Robot"; }
}
