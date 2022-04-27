package structure.decorator.exercice1;

public class Deca extends Boisson{
    public Deca(){
        this.description = "Deca";
    }
    @Override
    public double cout() {
        return 7;
    }
}
