package comportement.command.exercice2.commands;

import comportement.command.exercice2.entities.TV;

public class TurnOnTvCommand implements Command {
    private TV recepteur;
    public TurnOnTvCommand(TV recepteur){
        this.recepteur = recepteur;
    }
    @Override
    public void execute() {
        this.recepteur.turnOnTV();
    }
}