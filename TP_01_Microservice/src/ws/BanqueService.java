package ws;
import metier.*;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*
    Ce genre de classe c'est ce que on appel en Java un POJO :
        Plain Old Java Object
*/
@WebService (serviceName="BanqueWS")
public class BanqueService {
    @WebMethod(operationName="ConversionEuroToDH")
    public double conversion(@WebParam(name = "montant") double mtn){

        return mtn *10.6;
    }
    @WebMethod
    public Compte getCompte(@WebParam(name = "code") Long code){

        return new Compte(code, Math.random()*90000, new Date());
    }
    @WebMethod
    public List<Compte> listComptes(){
        List<Compte> comptes = new ArrayList<>();
        comptes.add( new Compte(1L, Math.random()*90000, new Date()) );
        comptes.add( new Compte(2L, Math.random()*90000, new Date()) );
        comptes.add( new Compte(3L, Math.random()*90000, new Date()) );
        return comptes;
    }
}
