package creation.abstractFactory.exercice1;

public class FactoryImplB implements AbstractFactory {
    @Override
    public AbstractPlugin getInstance() {
        return new PluginImplB();
    }
}
