package structure.proxy.exercice2;

public class TransactionalProxy implements IMetier {
    IMetier metier;
    @Override
    public void process() {
        System.out.println("BEGIN TR");
        metier  = new MetierImpl();
        metier.process();
        System.out.println("commit ou rollback");
        //
    }
}
