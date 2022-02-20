import javax.xml.ws.Endpoint;
import ws.*;


/*
    Pour convertir un objet java en xm ou l'inverse on utilise Le mapping object XML(OXM), on utilise la
    librairie JaxB - jax binding(il est integré dans le JDK dans les version 1.8 de java et moins), sachant
    JaxWS utilise autllomatiquement jaxB
    WSDL : http://0.0.0.0:8686/BanqueWS?wsdl
* */
public class ServeurJaxWS {
    public static void main(String[] args) {
        String url = "http://0.0.0.0:8687/";
        Endpoint.publish(url, new BanqueService());
        System.out.println("Web Service deployé sur l url : " + url);    }
}
