package structure.adapter.exercice1;

public class Client {
    private Standard standard;
    public void process(int nb1, int nb2){
        standard.operation(nb1,nb2);
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }
}
