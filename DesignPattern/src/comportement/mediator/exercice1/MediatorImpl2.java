package comportement.mediator.exercice1;

import java.util.ArrayList;
import java.util.List;

public class MediatorImpl2 extends Mediator{

    @Override
    public void forward(Message m) {
        System.out.println("-----------------------");
        System.out.println("Mediateur impl 2 ");
        System.out.println("Transmission du message "+ m.getContenu() +" de " + m.getSender() + " vers " + m.getReceiver());
        Collegue receiver = super.collegues.get(m.getReceiver());
        receiver.receive(m);

    }

}
