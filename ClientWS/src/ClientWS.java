import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

import java.util.List;

public class ClientWS {
    public static void main(String[] args) {
        BanqueService stubWS = new BanqueWS().getBanqueServicePort();
        //Invocation des methodes a distance
        System.out.println(stubWS.conversionEuroToDH(800));
        Compte cp = stubWS.getCompte(2L);
        System.out.println(cp.getCode());
        System.out.println(cp.getSolde());
        List<Compte> list = stubWS.listComptes();
        list.forEach( l -> {
            System.out.println("-------------------------");
            System.out.println(l.getCode());
            System.out.println(l.getSolde());
        });
    }

}
