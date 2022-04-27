package structure.decorator.exercice1.pk1;

import structure.decorator.exercice1.Boisson;

public class Chantilly extends AbstractDecorator{
    public Chantilly(Boisson boisson) {
        super(boisson);
    }
    @Override
    public String getDescription() {
        return boisson.getDescription()+" au chantilly";
    }
    @Override
    public double cout() {
        return 2.3+ super.boisson.cout();
    }
}
