package creation.abstractFactory.exercice1;

public class FactoryImplA implements AbstractFactory {
    @Override
    public AbstractPlugin getInstance() {
        return new PluginImplA();
    }
}
