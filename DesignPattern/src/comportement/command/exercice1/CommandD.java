package comportement.command.exercice1;

public class CommandD implements Command{
    private RecepteurImpl2 recepteur1;
    public CommandD(RecepteurImpl2 recepteur){
        this.recepteur1 = recepteur;
    }
    @Override
    public void executer() {
        this.recepteur1.action3();
    }
}
