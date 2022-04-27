package comportement.command.exercice2.invoquers;



import comportement.command.exercice2.commands.Command;

import java.util.HashMap;
import java.util.Map;

public class RemoteControl {
    private Map<String, Command> commandes;
    public RemoteControl(){
        this.commandes =  new HashMap<>();
    }
    public RemoteControl(String[] crefs, Command[] cs){
        this.commandes =  new HashMap<>();
        for (int i = 0; i < cs.length; i++) {
            this.addCommand(crefs[i],cs[i]);
        }
    }
    public void addCommand(String ref, Command c){
        this.commandes.put(ref,c);
    }
    public void invoque(String ref){
        Command c = this.commandes.get(ref);
        if (c!=null) c.execute();
    }
}

