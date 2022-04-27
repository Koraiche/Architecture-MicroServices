package comportement.strategy.exercice1;

public class Context {
    protected IFilesSavingStrategy strategy;
    public Context(IFilesSavingStrategy strategy){
        this.strategy = strategy;
    }
    public Context(){
        this.strategy = new StrategyImplDefault();
    }


    public void doSave(){
        System.out.println("\npre processing");
        this.strategy.saveStrategy();
        System.out.println("post processing");
    }
    public void setStrategy(IFilesSavingStrategy strategy){
        this.strategy = strategy;
    }
}
