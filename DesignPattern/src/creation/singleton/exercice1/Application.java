package creation.singleton.exercice1;

public class Application {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.traiter("study");
        singleton.traiter("study");
        singleton = Singleton.getInstance();
        singleton.traiter("study");
    }
}
