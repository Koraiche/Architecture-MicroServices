package structure.proxy.exercice2;

import structure.proxy.exercice1.Client;
import structure.proxy.exercice1.Proxy;

public class Application {
    public static void main(String[] args) {
        IMetier client = new TransactionalProxy();
        client.process();
    }
}
