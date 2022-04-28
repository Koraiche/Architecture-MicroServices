package comportement.mediator.exercice1;

public class CollegueImpl2 extends Collegue{
    @Override
    public void send(Message m) {
        System.out.println("Collegue 2 :" + super.getName() + " => ");
        System.out.print("Envoie du message vers " + m.getReceiver());
        m.setSender(this.getName());
        this.getMediator().forward(m);
    }

    @Override
    public void receive(Message m) {
        System.out.println("Collegue 2 :" + super.getName() + " => ");
        System.out.println("Contenu :" + m.getContenu());
        System.out.println("Sender :" +m.getSender());
        m.setSender(this.getName());
    }

    public CollegueImpl2(String n, Mediator mediator) {
        super(n, mediator);
    }

    public CollegueImpl2(String n) {
        super(n);
    }

    public CollegueImpl2() {
    }
}
