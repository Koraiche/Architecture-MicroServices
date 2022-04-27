package creation.singleton.exercice1;

public class Singleton {
    private int cpt;
    private static final Singleton singleton;
    static {
        singleton = new Singleton();
    }
    private Singleton(){
    }
    public static Singleton getInstance(){
        return singleton;
    }
    public void traiter(String taskName){
        System.out.println("Traitement de la tache " + taskName);
        for (int i = 0; i <= 5; i++) {
            synchronized (this){++cpt;}
            System.out.println(".." + cpt);

        }
    }
}
