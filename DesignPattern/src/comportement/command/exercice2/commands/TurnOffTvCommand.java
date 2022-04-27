package comportement.command.exercice2.commands;

import comportement.command.exercice2.entities.TV;

public class TurnOffTvCommand implements Command {
    private TV recepteur;
    public TurnOffTvCommand(TV recepteur){
        this.recepteur = recepteur;
    }
    @Override
    public void execute() {
        this.recepteur.turnOffTV();
    }
}