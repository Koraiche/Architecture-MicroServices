package creation.abstractFactory.exercice1;

public class PluginImplA implements  AbstractPlugin{
    @Override
    public void traitement() {
        System.out.println("Traitement du plugin A ...");
    }
}
