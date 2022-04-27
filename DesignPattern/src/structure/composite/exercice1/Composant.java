package structure.composite.exercice1;

public abstract class Composant {
    protected String name;
    protected int level;
    public Composant(String name){
        this.name = name;
    }
    public abstract void view();
    public String indentation(){
        String str = "";
        for (int i=0;i<this.level;i++){
            str+="\t";
        }
        return str;
    }
}
