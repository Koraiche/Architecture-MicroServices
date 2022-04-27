package structure.decorator.exercice1;

import structure.decorator.exercice1.pk1.Caramel;
import structure.decorator.exercice1.pk1.Chantilly;
import structure.decorator.exercice1.pk1.Chocolat;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("**********************");
        Boisson b = new Espresso();
        System.out.println(b.getDescription() +" : prix -> " + b.cout());
        System.out.println("**********************");
        b = new Chocolat(b);
        System.out.println(b.getDescription() +" : prix -> " + b.cout());
        System.out.println("**********************");
        b = new Chantilly(new Caramel(b));
        System.out.println(b.getDescription() +" : prix -> " + b.cout());
        System.out.println("**********************");

    }
}
