package structure.adapter.exercice1;

public class EquationAdapter implements Standard{
    private EquationPremierDegre equationPremierDegre = new EquationPremierDegre();
    @Override
    public void operation(int a, int b) {
        double res= equationPremierDegre.calculate((double)a,(double)b,(double)a-b);
        equationPremierDegre.print(res);
    }
}
