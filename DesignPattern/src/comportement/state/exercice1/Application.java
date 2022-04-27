package comportement.state.exercice1;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Avion avion = new AvionImpl();
        avion.doActivity();
        avion.sortirDuGarage();
        avion.entrerAuGarage();
        avion.sortirDuGarage();

    }
}
