package structure.adapter.exercice1;

public class StandardImpl1 implements Standard{
    @Override
    public void operation(int a, int b) {
        double res = a*b ;
        System.out.println("*************************");
        System.out.println("Implementation Standard 1");
        System.out.println("--> Resultat = " + res);

    }
}
