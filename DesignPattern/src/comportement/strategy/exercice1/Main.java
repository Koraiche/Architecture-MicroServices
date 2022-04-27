package comportement.strategy.exercice1;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------str 1-----------------");
        Context ctx = new Context();
        ctx.doSave();

        System.out.println("-----------------str 2-----------------");
        ctx.setStrategy(new StrategyImplDOCX());
        ctx.doSave();

        System.out.println("-----------------str 3-----------------");
        ctx.setStrategy(new StrategyImplTXT());
        ctx.doSave();

        System.out.println("-----------------str 4-----------------");
        ctx.setStrategy(new StrategyImplPDF());
        ctx.doSave();

    }
}
