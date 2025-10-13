public class Main {
    public static void main(String[] args) {
        Asztal asztal1 = new Asztal();
        
        Jatekos j1 = new Kezdo("Attila");
        Jatekos j2 = new Kezdo("Janos");
        Jatekos j3 = new Robot();

        asztal1.addJatekos(j1);
        asztal1.addJatekos(j2);
        asztal1.addJatekos(j3);

        asztal1.ujJatek();

        asztal1.kor();
        asztal1.kor();
        asztal1.kor();
    }

}
