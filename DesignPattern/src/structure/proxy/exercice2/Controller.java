package structure.proxy.exercice2;

public class Controller {
    //@Autowired  elle va cherche une classe @service a injecter
    private IMetier metier = new MetierImpl();
    public String index(){
        metier.process();
        return "index";
    }
}
