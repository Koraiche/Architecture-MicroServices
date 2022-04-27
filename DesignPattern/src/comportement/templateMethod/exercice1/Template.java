package comportement.templateMethod.exercice1;

public abstract class Template {
    public double computeTemplate(double x, double y){
        double data = x * y;
        double param = this.detail1(data);
        double somme  = y;
        for (int i = 0; i < param; i++) {
            double value = this.detail2(x,y,param);
            somme += value;
        }
        return somme;
    }
    protected abstract int detail1(double data);
    protected abstract double detail2(double x, double y, double param);
}
