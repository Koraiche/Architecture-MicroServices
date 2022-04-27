package ma.s2m;

import jakarta.xml.bind.DatatypeConverter;
import org.apache.commons.codec.binary.Hex;
import java.util.Base64;
import java.util.Formatter;

public class CryptoUtilImpl {
    public String encodeToBase64(byte[] bytes){
        return Base64.getEncoder().encodeToString(bytes);
    }
    public byte[] decodeFromBase64(String data){
        return Base64.getDecoder().decode(data.getBytes());
    }
    public String encodeToBase64URL(byte[] bytes){
        return Base64.getUrlEncoder().encodeToString(bytes);
    }
    public byte[] decodeFromBase64URL(String data){
        return Base64.getUrlDecoder().decode(data.getBytes());
    }
    public String encodeToHexa(byte[] bytes){
        return DatatypeConverter.printHexBinary(bytes);
    }
    public byte[] decodeFromHexa(String data){
        return DatatypeConverter.parseHexBinary(data);
    }

    public String encodeToHexaApacheCodec(byte[] data){
        return Hex.encodeHexString(data);
    }
    public String encodeToHexaManually(byte[] data){
        Formatter formatter = new Formatter();
        for(byte b:data){
            formatter.format("%02x",b);
        }
        return formatter.toString();
    }
}
