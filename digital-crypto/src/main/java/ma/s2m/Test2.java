package ma.s2m;

import jakarta.xml.bind.DatatypeConverter;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;


public class Test2 {
    public static void main(String[] args) {
        CryptoUtilImpl crypto = new CryptoUtilImpl();
        String document = "Hello from S2M >>>";
        String dataBase64 = crypto.encodeToBase64(document.getBytes());
        String dataBase64URL = crypto.encodeToBase64URL(document.getBytes());
        System.out.println(dataBase64);
        System.out.println(dataBase64URL);

        byte[] decodedBytes = crypto.decodeFromBase64(dataBase64);
        byte[] decodedBytes2 = crypto.decodeFromBase64URL(dataBase64URL);
        System.out.println(new String(decodedBytes));
        System.out.println(new String(decodedBytes2));

        String dataBaseHexa = crypto.encodeToHexa(document.getBytes());
        String dataBaseHexaApacheCodec = crypto.encodeToHexaApacheCodec(document.getBytes());
        String dataBaseHexaManually = crypto.encodeToHexaManually(document.getBytes());
        System.out.println(dataBaseHexa);
        System.out.println(dataBaseHexaApacheCodec);
        System.out.println(dataBaseHexaManually);
        byte[] dataFromHexa = crypto.decodeFromHexa(dataBaseHexa);
        System.out.println(new String(dataFromHexa));
    }
}
