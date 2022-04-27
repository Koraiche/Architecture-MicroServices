package comportement.observer.exercice1;

public class Application {
    public static void main(String[] args) {
        ObservableImpl observable = new ObservableImpl();
        Observer obs1 = new ObserverImpl1();
        Observer obs2 = new ObserverImpl2();
        Observer obs3 = new ObserverImpl1();
        System.out.println(((ObserverImpl1)obs1).getState());
        observable.subscribe(obs1);
        observable.setState(10);
        System.out.println(((ObserverImpl1)obs1).getState());
        observable.subscribe(new Observer(){
            @Override
            public void update(Observable obsl) {
                System.out.println("Observateur anonyme 1");
            }
        });
        observable.subscribe(obs->{
            System.out.println("Observateur anonyme 2");
        });
        observable.setState(20);
    }

}
