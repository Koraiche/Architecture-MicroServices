package structure.decorator.exercice1.pk1;

import structure.decorator.exercice1.Boisson;

public class Vanille extends AbstractDecorator{
    Vanille(Boisson boisson) {
        super(boisson);
    }
    @Override
    public String getDescription() {
        return boisson.getDescription()+" au vanille";
    }
    @Override
    public double cout() {
        return 1.05+ super.boisson.cout();
    }
}
