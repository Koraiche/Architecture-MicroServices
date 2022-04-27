package ma.s2m;

import java.util.Arrays;
import java.util.Base64;

public class Test1 {
    public static void main(String[] args) {
        String document = "Ceci est mon message";
        System.out.println("String : " + document);
        byte[] bytes = document.getBytes();
        System.out.println("String -> bytes :" + Arrays.toString(bytes));
        String documentBase64 = Base64.getEncoder().encodeToString(bytes);
        System.out.println("Bytes -> Base64 :" + documentBase64);
        String documentBase64URL = Base64.getUrlEncoder().encodeToString(bytes);
        System.out.println("Bytes -> Base64URL :" + documentBase64);
        byte[] decodedURL = Base64.getUrlDecoder().decode(documentBase64);
        System.out.println("Base64URL -> String :" + new String(decodedURL));
        byte[] decoded = Base64.getDecoder().decode(documentBase64);
        System.out.println("Base64 -> String :" + new String(decoded));
    }
}
