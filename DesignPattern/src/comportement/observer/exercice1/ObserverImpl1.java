package comportement.observer.exercice1;

public class ObserverImpl1 implements Observer {
    double state=0;
    @Override
    public void update(Observable obsl) {
        state = ((ObservableImpl)obsl).getState()*10 +0.67777;
        System.out.println("*********** Observer Impl 1 ***********");
        System.out.println("Nouvelle mise a jour");
        System.out.println("resultat = " + state);
        System.out.println("***************************************");
    }
    public double getState(){
        return state;
    }
}
