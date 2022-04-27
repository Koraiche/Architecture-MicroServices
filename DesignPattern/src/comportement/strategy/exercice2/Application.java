package comportement.strategy.exercice2;

public class Application {
    public static void main(String[] args) {
        Personnage p = new Roi();
        p.combattre();
        p.setArme(new ComportementArcEtFleche());
        p.combattre();
    }
}
