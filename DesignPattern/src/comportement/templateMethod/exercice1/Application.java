package comportement.templateMethod.exercice1;

public class Application {
/*
* The template pattern is used when a particular operation has some invariant behavior(s) that can be
* defined in terms of other varying primitive behaviors. The abstract class defines the invariant
* behavior(s), while the implementing classes defined the dependent methods. In a strategy, the
* behavior implementations are independent -- each implementing class defines the behavior and
* there is no code shared between them. Both are behavioral patterns and, as such, are consumed
* in much the same way by clients. Typically strategies have a single public method -- the execute()
*  method, whereas templates may define a set of public methods as well as a set of supporting
*  private primitives that subclasses must implement.  The two patterns could easily be used
* together. You might have a strategy pattern where several implementations belong to a
* family of strategies implemented using a template pattern.
* */
public static void main(String[] args) {
    Template template =  new TemplateImpl1();
    System.out.println(template.computeTemplate(6,90));
    template = new TemplateImpl2();
    System.out.println(template.computeTemplate(6,90));
}

}
