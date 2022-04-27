package comportement.observer.exercice1;

import java.util.ArrayList;
import java.util.List;

public class ObservableImpl implements Observable {
    private int state = 10;
    private List<Observer> observers = new ArrayList<>();
    @Override
    public void subscribe(Observer obs) {
        this.observers.add(obs);
    }

    @Override
    public void unsubscribe(Observer obs) {
        this.observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for(Observer o:this.observers){
            o.update(this);
        }
    }
    public void setState(int i){
        this.state = i;
        this.notifyObservers();
    }
    public int getState(){
        return this.state;
    }
}
