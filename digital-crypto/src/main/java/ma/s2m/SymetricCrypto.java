package ma.s2m;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class SymetricCrypto {

    public static SecretKey generateSecretKey(String secret) throws Exception {
        return new SecretKeySpec(secret.getBytes(),0,secret.length(),"AES");
    }
    public static SecretKey generateSecretKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }
    public static String generateStringSecretKey() throws Exception {
        byte[] bytes =  generateSecretKey().getEncoded();
        System.out.println(Arrays.toString(bytes));
        return new String(bytes);
    }


    public static String EncryptAES(String data, String secret) throws Exception {

        Cipher cipher = Cipher.getInstance("AES");
        SecretKey secretKey = new SecretKeySpec(secret.getBytes(),0,secret.length(),"AES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        byte[] encodedEncryptedData = Base64.getEncoder().encode(encryptedData);
        String stringEncodedEncryptedData = Base64.getEncoder().encodeToString(encryptedData);
        //System.out.println(encryptedData);
        //System.out.println(encodedEncryptedData);
        //System.out.println(stringEncodedEncryptedData);
        return stringEncodedEncryptedData;

    }
    public static String DecryptAES(String data,String secret) throws Exception {
        byte[] decodedEncryptedData = Base64.getDecoder().decode(data) ;
        Cipher cipher = Cipher.getInstance("AES");
        SecretKey secretKey = new SecretKeySpec(secret.getBytes(),0,secret.length(),"AES");
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        byte[] decryptedBytes = cipher.doFinal(decodedEncryptedData);
        //System.out.println(new String(decryptedBytes));
        return new String(decryptedBytes);
    }

    public static void main(String[] args) throws Exception {
       //secret => 16char * 8bits = 128bit, three different key lengths: 128, 192 and 256 bits.
        String messageToEncrypt = "This is my message";
        String secretKey = generateStringSecretKey();
        System.out.println(secretKey);
       String encodedEncryption = EncryptAES(messageToEncrypt,secretKey);
       String decodedEncryption = DecryptAES(encodedEncryption,secretKey);
       System.out.println(decodedEncryption);
    }
}
