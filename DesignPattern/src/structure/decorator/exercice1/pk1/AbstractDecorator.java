package structure.decorator.exercice1.pk1;

import structure.decorator.exercice1.Boisson;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDecorator extends Boisson {
    protected Boisson boisson;
    AbstractDecorator(Boisson boisson){
        this.boisson = boisson;
    }
    public abstract String getDescription();

}
