package comportement.command.exercice2.commands;

import comportement.command.exercice2.entities.SmartWindow;

public class OpenWindowCommand implements Command {
    private SmartWindow recepteur;
    public OpenWindowCommand(SmartWindow recepteur){
        this.recepteur = recepteur;
    }
    @Override
    public void execute() {
        this.recepteur.openSmartWindow();
    }
}