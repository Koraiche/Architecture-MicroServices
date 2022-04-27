package comportement.state.exercice1;

public interface Avion {
    void sortirDuGarage();
    void entrerAuGarage();
    void decoller();
    void atterir();
    void doActivity() throws InterruptedException;
}
