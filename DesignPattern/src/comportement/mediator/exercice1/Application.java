package comportement.mediator.exercice1;

public class Application {
    public static void main(String[] args) {
        Mediator m1 = new MediatorImpl1();
        Collegue c1 = new CollegueImpl1("Fahd",m1);
        Collegue c2 = new CollegueImpl1("Amine",m1);
        Collegue c3 = new CollegueImpl1("Salah",m1);

        c1.send(new Message("Premier message","Amine"));
        c1.send(new Message("Deuxieme message","Salah"));
        c2.send(new Message("Troisieme","Salah"));
    }
}
