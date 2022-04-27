package comportement.command.exercice1;

public class CommandB implements Command{
    private RecepteurImpl1 recepteur1;
    public CommandB(RecepteurImpl1 recepteur){
        this.recepteur1 = recepteur;
    }
    @Override
    public void executer() {
        this.recepteur1.action2();
    }
}
