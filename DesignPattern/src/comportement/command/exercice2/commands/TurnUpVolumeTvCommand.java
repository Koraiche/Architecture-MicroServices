package comportement.command.exercice2.commands;

import comportement.command.exercice2.entities.TV;

public class TurnUpVolumeTvCommand implements Command {
    private TV recepteur;
    public TurnUpVolumeTvCommand(TV recepteur){
        this.recepteur = recepteur;
    }
    @Override
    public void execute() {
        this.recepteur.turnUpVolumeTV();
    }
}