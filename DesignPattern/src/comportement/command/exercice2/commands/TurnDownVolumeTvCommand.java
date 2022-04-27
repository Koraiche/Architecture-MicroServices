package comportement.command.exercice2.commands;

import comportement.command.exercice2.commands.Command;
import comportement.command.exercice2.entities.TV;

public class TurnDownVolumeTvCommand implements Command {
    private TV recepteur;
    public TurnDownVolumeTvCommand(TV recepteur){
        this.recepteur = recepteur;
    }
    @Override
    public void execute() {
        this.recepteur.turnDownVolumeTV();
    }
}
