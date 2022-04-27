package comportement.command.exercice1;

public class CommandC implements Command{
    private RecepteurImpl2 recepteur1;
    public CommandC(RecepteurImpl2 recepteur){
        this.recepteur1 = recepteur;
    }
    @Override
    public void executer() {
        this.recepteur1.action1();
    }
}
