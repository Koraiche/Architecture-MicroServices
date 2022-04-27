package structure.composite.exercice1;

import java.util.ArrayList;
import java.util.List;

//Composite
public class Folder extends Composant{
    private List<Composant> components;
    public Folder(String name) {
        super(name);
        this.components = new ArrayList<>();
    }
    @Override
    public void view() {
        System.out.println(super.indentation() + "Folder : " + this.name);
        for(Composant c: this.components){
            c.view();
        }
    }
    public Composant addComponent(Composant composant){
        composant.level = this.level + 1;
        this.components.add(composant);
        return composant;
    }
}
