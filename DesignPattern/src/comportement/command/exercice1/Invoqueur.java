package comportement.command.exercice1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Invoqueur {
    private Map<String,Command> commandes = new HashMap<>();
    Invoqueur(){

    }
    Invoqueur(String[] crefs, Command[] cs){
        for (int i = 0; i < cs.length; i++) {
            this.addCommand(crefs[i],cs[i]);
        }
    }
    public void addCommand(String ref, Command c){
        this.commandes.put(ref,c);
    }
    public void invoque(String ref){
        Command c = this.commandes.get(ref);
        if (c!=null) c.executer();
    }
}
