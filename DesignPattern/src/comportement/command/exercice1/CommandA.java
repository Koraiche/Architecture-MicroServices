package comportement.command.exercice1;

public class CommandA implements Command{
    private RecepteurImpl1 recepteur1;
    public CommandA(RecepteurImpl1 recepteur){
        this.recepteur1 = recepteur;
    }
    @Override
    public void executer() {
        this.recepteur1.action1();
    }
}
