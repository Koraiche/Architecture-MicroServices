package ma.s2m;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Locale;

public class AsymetricCrypto {

    public static KeyPair generateKeyPair() throws  Exception{
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);//1024 - 512
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }
    public static PublicKey publicKeyFromBase64(String pkBase64) throws  Exception{
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        String publicKeyBase64Str = pkBase64;
        byte[] decodedKey = Base64.getDecoder().decode(publicKeyBase64Str);
        PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(decodedKey));
        return publicKey;
    }
    public static PublicKey publicKeyFromCertificate(String fileName) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(fileName);
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        Certificate certificate = certificateFactory.generateCertificate(fileInputStream);
        System.out.println(certificate.toString());
        return certificate.getPublicKey();
    }
    public static PrivateKey privateKeyFromCertificate(String fileName, String pwd, String alias) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(fileName);
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(fileInputStream,pwd.toCharArray());
        Key key = keyStore.getKey(alias, pwd.toCharArray());
        PrivateKey privateKey = (PrivateKey) key;
        return privateKey;
    }
    public static PrivateKey privateKeyFromBase64(String pkBase64) throws  Exception{
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        String privateKeyBase64Str = pkBase64;
        byte[] decodedPrivateKey = Base64.getDecoder().decode(privateKeyBase64Str);
        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decodedPrivateKey));
        return privateKey;
    }
    public static String encrypt(byte[] data, PublicKey publicKey) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        byte[] encryptedBytes = cipher.doFinal(data);
        System.out.println("Encrypted message");
        System.out.println(Base64.getEncoder().encodeToString(encryptedBytes));
        String encrypted = Base64.getEncoder().encodeToString(encryptedBytes);
        return encrypted;
    }
    public static byte[] decrypt(String data, PrivateKey privateKey) throws Exception{
        Cipher decipher = Cipher.getInstance("RSA");
        decipher.init(Cipher.DECRYPT_MODE,privateKey);
        byte[] decryptedBytes = decipher.doFinal(Base64.getDecoder().decode(data));
        System.out.println("Decrypted message");
        System.out.println(new String(decryptedBytes));
        //String decrypted = Base64.getEncoder().encodeToString(decryptedBytes);
        return decryptedBytes;
    }
    public static String hmacSign(byte[] data, String privateSecret) throws Exception{
        //HMAC est symetric, il utilise la meme cle pour signer et pour verifier la signature !
        //Hash Message authentification code, ici on va utiliser SHA256 pour le hashage
        SecretKeySpec secretKeySpec = new SecretKeySpec(privateSecret.getBytes(),"HmacSha256");
        Mac mac = Mac.getInstance("HmacSha256");
        mac.init(secretKeySpec);
        byte[] signature = mac.doFinal(data);

        return Base64.getEncoder().encodeToString(signature);
    }
    public static boolean hmacVerify(String document, String secret) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(),"HmacSha256");
        Mac mac = Mac.getInstance("HmacSha256");
        String[] data = document.split("_.._");
        String doc = data[0];
        String sig = data[1];
        mac.init(secretKeySpec);
        byte[] signature = mac.doFinal(doc.getBytes());
        String base64Sign = Base64.getEncoder().encodeToString(signature);
        return base64Sign.equals(sig);
    }
    public static String rsaSign(byte[] data, PrivateKey privateKey) throws Exception{
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey,new SecureRandom());
        signature.update(data);
        byte[] sign = signature.sign();
        return Base64.getEncoder().encodeToString(sign);
    }
    public static boolean rsaVerify  (String signedDoc, PublicKey publicKey) throws Exception{
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        String[] data = signedDoc.split("_.._");
        String document = data[0];
        String sign = data[1];
        byte[] decodedSignature = Base64.getDecoder().decode(sign);
        signature.update(document.getBytes());
        boolean verify = signature.verify(decodedSignature);
        return verify;
    }
        public static void main(String[] args) throws Exception {

        String data = "Voici mon message clair à chiffrer";

        PublicKey publicKey = publicKeyFromBase64("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJtTHVhTQIjchUdAhVH3DcIAjxxgI538vERWHmw8bd9TeA3DlslzLmBBXBMx0u0cwIVY1+KxAAGuBEUZ6UVst7kCAwEAAQ==");
        PrivateKey privateKey = privateKeyFromBase64("MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAm1MdWFNAiNyFR0CFUfcNwgCPHGAjnfy8RFYebDxt31N4DcOWyXMuYEFcEzHS7RzAhVjX4rEAAa4ERRnpRWy3uQIDAQABAkA88Mo1qkxKpkLAZucn9od2U2PS3UF8Lfnr0eIT003Ebc233OOGDw5p0rmIvxjCt2nBOPOiA+wZSLeK3Sdanhi1AiEAz1ATpMklTt7EjyhYaaGSZANnUNlcZ0BvLmUkC0NMY88CIQC/zXERqXYzSYXtNcrKcCrEwtR6J1Uc/8LnezfYBFyl9wIhAJBApgqJtB4XQCpk5nBJ7vUMsT0+od9upG5iDhyQLX1dAiBTC8jhNNaQ7kymoJvlexuJhjIpkc4weC0TvS44weq7kQIgPJzZrmWsPuKfWAN0OVlElZnHWNV29DvFa7RAsjzG9/Q=");

        String encrypted = encrypt(data.getBytes(),publicKey);
        System.out.println(encrypted);
        String decrypted = new String(decrypt(encrypted,privateKey));
        System.out.println(decrypted);

        System.out.println("======================================================================");

        PublicKey publicKey1 = publicKeyFromCertificate("myCertificate.cert");
        System.out.println(new String(Base64.getUrlEncoder().encode(publicKey1.getEncoded())));
        PrivateKey privateKey1 = privateKeyFromCertificate("fahd.jks","123456","fahd");
        System.out.println(new String(Base64.getUrlEncoder().encode(privateKey1.getEncoded())));

        String encrypted1 = encrypt(data.getBytes(),publicKey1);
        System.out.println(encrypted1);
        String decrypted1 = new String(decrypt(encrypted1,privateKey1));
        System.out.println(decrypted1);

        System.out.println("======================================================================");
        String secret = "azerty";
        String document = "This is my message";
        String signature = hmacSign(document.getBytes(),secret);
        String signedDocument = document + "_.._" + signature;
        System.out.println(signedDocument);
        System.out.println("Signature verification ======================================================================");

        boolean signatureVerif = hmacVerify(signedDocument,secret);
            System.out.println(signatureVerif);
            System.out.println("===================================");
            PublicKey publicKey2 = publicKeyFromCertificate("myCertificate.cert");
            System.out.println(new String(Base64.getUrlEncoder().encode(publicKey2.getEncoded())));
            PrivateKey privateKey2 = privateKeyFromCertificate("fahd.jks","123456","fahd");
            System.out.println(new String(Base64.getUrlEncoder().encode(privateKey2.getEncoded())));

            String dataa = "This is my message";
            String sig = rsaSign(dataa.getBytes(),privateKey2);
            String signedDoc = dataa + "_.._" + sig;
            System.out.println(signedDoc);

            boolean b = rsaVerify(signedDoc,publicKey2);
            System.out.println("Signature verification : "+b);
    }
}
