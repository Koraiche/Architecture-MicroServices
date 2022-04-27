package comportement.templateMethod.exercice1;

public class TemplateImpl2 extends Template{
    @Override
    protected int detail1(double input) {
        return (int) Math.atan(input);
    }

    @Override
    protected double detail2(double x, double y, double param) {
        double w = x*y/param;
        return w + param;
    }
}
