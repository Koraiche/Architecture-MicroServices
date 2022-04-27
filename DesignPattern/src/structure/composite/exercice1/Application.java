package structure.composite.exercice1;

public class Application {
    public static void main(String[] args) {
        Folder desktop = new Folder("C:");
        desktop.addComponent(new File("config.json"));
        desktop.addComponent(new File("git.init"));
        Folder Perso = new Folder("Perso");
        desktop.addComponent(Perso);
        Perso.addComponent(new File("pwd.txt"));
        Perso.addComponent(new File("emails.txt"));
        Perso.addComponent(new File("logs.txt"));


        desktop.view();
    }
}
