package structure.proxy.exercice1;

public class Client {
    private Standard standard;
    public void setStandard(Standard standard) {
        this.standard = standard;
    }


    public void process(){
        this.standard.process();
    }
}
