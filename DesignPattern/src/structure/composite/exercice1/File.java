package structure.composite.exercice1;

public class File extends Composant{
    public File(String name) {
        super(name);
    }

    @Override
    public void view() {

        System.out.println(super.indentation() + "File : " + this.name);
    }
}
