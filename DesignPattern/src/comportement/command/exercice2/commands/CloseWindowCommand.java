package comportement.command.exercice2.commands;

import comportement.command.exercice2.entities.SmartWindow;


public class CloseWindowCommand implements Command {
    private SmartWindow recepteur;
    public CloseWindowCommand(SmartWindow recepteur){
        this.recepteur = recepteur;
    }
    @Override
    public void execute() {
        this.recepteur.closeSmartWindow();
    }
}
