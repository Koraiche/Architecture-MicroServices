package comportement.mediator.exercice1;

import java.util.HashMap;
import java.util.Map;

public abstract class Mediator {
    protected Map<String, Collegue> collegues;
    Mediator(){
        this.collegues= new HashMap<>();
    }
    public void addCollegue(String ref, Collegue c){
        this.collegues.put(ref,c);
    }
    public abstract void forward(Message m);

}
