public abstract class Jatekos {
    public void lep() {
        System.out.println("Jelenleg a " + asztal.getKor() + " kornel jarunk!");
        System.out.println("A tet: " + asztal.getTet());
    }
    public void setAsztal(Asztal a) { asztal = a;}

    protected Asztal asztal;
}
