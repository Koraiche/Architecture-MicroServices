package comportement.command.exercice1;

public class Application {
    public static void main(String[] args) {

        RecepteurImpl1 r1 = new RecepteurImpl1();
        RecepteurImpl2 r2 = new RecepteurImpl2();

        Command cmd1 = new CommandA(r1);
        Command cmd2 = new CommandB(r1);
        Command cmd3 = new CommandC(r2);
        Command cmd4 = new CommandD(r2);

        Invoqueur i = new Invoqueur(
            new String[]{"commande 1","commande 2","commande 3", "commande 4"},
            new Command[]{cmd1,cmd2,cmd3,cmd4}
        );
        i.invoque("commande 1");
        i.invoque("commande 2");
        i.invoque("commande 3");
        i.invoque("commande 4");
    }
}
