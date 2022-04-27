package comportement.observer.exercice1;

public class ObserverImpl2 implements Observer {
    int counter;
    @Override
    public void update(Observable obsl) {
        double state = ((ObservableImpl)obsl).getState()*90 - 55.67777;
        counter++;
        System.out.println("*********** Observer Impl 2 ***********");
        System.out.println("Nouvelle mise a jour");
        System.out.println("resultat = " + state);
        System.out.println("compteur => " + counter);
        System.out.println("***************************************");
    }
}
