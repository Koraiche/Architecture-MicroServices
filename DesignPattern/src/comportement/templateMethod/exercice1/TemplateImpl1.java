package comportement.templateMethod.exercice1;

public class TemplateImpl1 extends Template{
    @Override
    protected int detail1(double input) {
        return (int) Math.sqrt(input);
    }

    @Override
    protected double detail2(double x, double y, double param) {
        double w = x/y;
        return w*param;
    }
}
