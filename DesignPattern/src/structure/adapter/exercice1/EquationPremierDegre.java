package structure.adapter.exercice1;

public class EquationPremierDegre {
    public double calculate(double a, double b, double c){
        return a*b + c;
    }
    public void print(double nb){
        System.out.println("*************************");
        System.out.println("Ancienne Implementation");
        System.out.println("nb -> " + nb);
    }
}
