package structure.proxy.exercice2;

import structure.proxy.exercice2.IMetier;

public class MetierImpl implements IMetier {
    @Override
    public void process() {
        System.out.println("Traitement");
    }
}
