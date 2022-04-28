package comportement.mediator.exercice1;

import java.util.ArrayList;
import java.util.List;

public class MediatorImpl1 extends Mediator{
    private List<Message> conversation = new ArrayList<>();
    @Override
    public void forward(Message m) {
        System.out.println("-----------------------");
        System.out.println("Mediateur impl 1 ");
        System.out.println("Transmission du message "+ m.getContenu() +" de " + m.getSender() + " vers " + m.getReceiver());
        Collegue receiver = super.collegues.get(m.getReceiver());
        receiver.receive(m);
        this.conversation.add(m);
    }
    public void analyserConversation(){
        for(Message m: this.conversation){
            System.out.println(m.toString());
        }
    }
}
