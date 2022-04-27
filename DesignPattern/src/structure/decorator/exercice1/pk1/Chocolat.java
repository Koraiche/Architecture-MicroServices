package structure.decorator.exercice1.pk1;

import structure.decorator.exercice1.Boisson;

public class Chocolat extends AbstractDecorator{
    public Chocolat(Boisson boisson) {
        super(boisson);
    }
    @Override
    public String getDescription() {
        return boisson.getDescription()+" au chocolat";
    }
    @Override
    public double cout() {
        return 0.7+ super.boisson.cout();
    }
}
