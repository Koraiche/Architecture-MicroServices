package creation.singleton.exercice2;

import creation.singleton.exercice1.Singleton;

public class ThreadedTask extends Thread{
    private String taskName;
    ThreadedTask(String name){
        this.taskName = name;
    }

    @Override
    public void run() {
        Singleton instance = Singleton.getInstance();
        instance.traiter(this.taskName);
    }
}
