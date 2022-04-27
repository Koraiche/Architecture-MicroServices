package structure.decorator.exercice1;

public abstract class Boisson {
    protected String description;
    public abstract double cout();
    public String getDescription(){
        return this.description;
    }
}
