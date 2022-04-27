package comportement.observer.exercice1;

public interface Observable //Subject
{
    public void subscribe(Observer obs);
    public void unsubscribe(Observer obs);
    public void notifyObservers();

}
