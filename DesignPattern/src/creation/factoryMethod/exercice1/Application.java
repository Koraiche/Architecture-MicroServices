package creation.factoryMethod.exercice1;

import java.util.Scanner;

public class Application {
    /*
    * The main difference between a “factory method” and an “abstract factory” is that the factory
    * method is a single method, and an abstract factory is an object.
    * The factory method is just a method, it can be overridden in a subclass, whereas the abstract
    *  factory is an object that has multiple factory methods on it. The Factory Method pattern
    *  uses inheritance and relies on a subclass to handle the desired object instantiation.
    * */
    public static void main(String[] args) {
        PlanFactoryMethod planFactory = new PlanFactoryMethod();

        Plan domesticPlan = planFactory.getPlanInstance("DOMESTICPLAN");
        domesticPlan.updateRate();
        domesticPlan.calculateBill(50);

        Plan commerialPlan = planFactory.getPlanInstance("COMMERCIALPLAN");
        commerialPlan.updateRate();
        commerialPlan.calculateBill(50);

        Plan institutionalPlan = planFactory.getPlanInstance("INSTITUTIONALPLAN");
        institutionalPlan.updateRate();
        institutionalPlan.calculateBill(50);
    }

}
