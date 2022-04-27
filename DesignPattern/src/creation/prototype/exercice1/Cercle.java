package creation.prototype.exercice1;

public class Cercle extends Figure{
    public Cercle(Point p1, Point p2) {
        super(p1, p2);
    }

    @Override
    public double surface() {
        double rayon = this.p1.distance(p2);
        return Math.PI * rayon * rayon;
    }

    @Override
    public String toString() {
        return "Cercle { " + super.toString() + " } ";
    }
}
