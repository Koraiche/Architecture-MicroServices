package creation.abstractFactory.exercice1;

import javax.swing.table.AbstractTableModel;

public class Application {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //INSTANCIATION STATIQUE
        AbstractFactory factory1 = new FactoryImplA();
        AbstractPlugin abstractPlugin1 = factory1.getInstance();
        abstractPlugin1.traitement();

        //INSTANCIATION DYNAMIQUE
        AbstractFactory factory2 = (AbstractFactory)Class.forName("creation.abstractFactory.exercice1.FactoryImplB").newInstance();
        AbstractPlugin abstractPlugin2 = factory2.getInstance();
        abstractPlugin2.traitement();
    }
}
