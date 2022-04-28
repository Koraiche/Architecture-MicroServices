package comportement.mediator.exercice1;

public abstract class Collegue {
    private Mediator mediator;
    private String name;
    public Collegue(String n,Mediator mediator){
        this.mediator = mediator;
        this.name = n;
        mediator.addCollegue(n,this);
    }
    public Collegue(String n){
        this.name = n;

    }
    public Collegue(){
    }
    public abstract void send(Message m);
    public abstract void receive(Message m);

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Mediator getMediator() {
        return this.mediator;
    }
    public void setMediator(Mediator m) {
        this.mediator = m;
    }
}
