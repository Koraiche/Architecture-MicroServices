package creation.factoryMethod.exercice1;

abstract class Plan{
    protected double rate;
    abstract void updateRate();

    public void calculateBill(int units){
        System.out.println(units*rate);
    }
}