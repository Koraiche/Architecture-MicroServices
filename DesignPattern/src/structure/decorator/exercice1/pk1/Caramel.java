package structure.decorator.exercice1.pk1;

import structure.decorator.exercice1.Boisson;

public class Caramel extends AbstractDecorator{
    public Caramel(Boisson boisson) {
        super(boisson);
    }
    @Override
    public String getDescription() {
        return boisson.getDescription()+" au caramel";
    }
    @Override
    public double cout() {
        return 0.9+ super.boisson.cout();
    }
}
