package structure.decorator.exercice1;

public class Espresso extends Boisson{
    public Espresso(){
        this.description = "Espresso";
    }
    @Override
    public double cout() {
        return 6;
    }
}
