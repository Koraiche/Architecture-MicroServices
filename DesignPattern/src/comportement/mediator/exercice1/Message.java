package comportement.mediator.exercice1;

public class Message {
    private String contenu;
    private String sender;

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    private String receiver;
    public Message(String c,String r, String s){
        this.contenu = c;
        this.sender = s;
        this.receiver = r;
    }
    public Message(String c,String r){
        this.contenu = c;
        //this.sender = s;
        this.receiver = r;
    }

    @Override
    public String toString() {
        return "Message{" +
                "contenu='" + contenu + '\'' + ", sender='" + sender + '\'' + ", receiver='" + receiver + '\'' + '}';
    }
}
