package creation.singleton.exercice2;

public class Application {
    public static void main(String[] args) {
        ThreadedTask task1 =  new ThreadedTask("Fahd ");task1.start();
        ThreadedTask task2 =  new ThreadedTask("Salah ");task2.start();
        ThreadedTask task3 =  new ThreadedTask("Amine ");task3.start();
        ThreadedTask task4 =  new ThreadedTask("Yazid ");task4.start();


    }
}
