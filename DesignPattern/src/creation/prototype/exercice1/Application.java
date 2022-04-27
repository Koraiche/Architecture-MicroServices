package creation.prototype.exercice1;

public class Application {
    public static void main(String[] args) throws CloneNotSupportedException {
        Figure f1 = new Cercle(new Point(10,10), new Point(20,20));
        Figure f2 = new Rectangle(new Point(30,30), new Point(40,40));

        System.out.println("Surface de " + f1 + " est " + f1.surface() + ".");
        System.out.println("Surface de " + f2 + " est " + f2.surface() + ".");

        System.out.println("Copie 1 de f1 : ");
        Figure f3 = f1.clone();
        System.out.println("Surface de " + f3 + " est " + f3.surface() + ".");

        System.out.println("Copie 1 de f2 : ");
        Figure f4 = f2.clone();
        System.out.println("Surface de " + f4 + " est " + f4.surface() + ".");

        f1.p1.x = 50;

        System.out.println(f1.surface());
        System.out.println(f3.surface());



    }
}
