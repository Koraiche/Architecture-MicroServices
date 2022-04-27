package creation.prototype.exercice1;

public class Rectangle extends Figure{
    public Rectangle(Point p1, Point p2) {
        super(p1, p2);
    }

    @Override
    public double surface() {
        int L  = Math.abs(p1.x - p2.x);
        int H  = Math.abs(p1.y - p2.y);
        return L * H;
    }

    @Override
    public String toString() {
        return "Rectangle { " + super.toString() + " }";
    }
}
