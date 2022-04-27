package comportement.strategy.exercice2;

public abstract class Personnage {
    ComportementArme arme;
    Personnage(){
        this.arme = new ComportementPoignard();
    }

    public void setArme(ComportementArme arme) {
        this.arme = arme;
    }

    public void combattre(){
        arme.utiliserArme();
    }
}
