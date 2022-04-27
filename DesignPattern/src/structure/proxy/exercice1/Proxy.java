package structure.proxy.exercice1;

import java.util.Random;

public class Proxy implements  Standard{
    private StandardImpl1 target;
    @Override
    public void process() {
        System.out.println("Verification du contexte de securite");
        if(new Random().nextBoolean()){
            this.target = new StandardImpl1();
            this.target.process();
        }
        else{
            System.out.println("Not allowed");
        }
    }
}
