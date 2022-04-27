package structure.adapter.exercice1;

public class Application {
    public static void main(String[] args) {
        Client client = new Client();
        client.setStandard(new StandardImpl1());
        client.process(4,5);
        client.setStandard(new StandardImpl2());
        client.process(4,5);
        client.setStandard(new EquationAdapter());
        client.process(4,5);

    }

}
