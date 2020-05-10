package RSAJava;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.security.*;
import javax.crypto.*;

public class RSAUtil
{
    private static String publicKey = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEApQ8p2l7DhGVFELlTbmPzrU6C4yySAHVcw+Z9+3E5WtVkCERL0qIBnelKGAp9qlUhB3jLSc3zyk0iGyVSj7OG3WbVrDiQ9PlMk6bD9iTCY2MH9yhXeRETQ1S0xLpKviDwWUizmOWfxexotBRug/tNb9T5bLvz+Sdkle2cudpI6oQvhn7N0s2LR+w8pt5257KVgAQXrSOYCFDYn2x0tRpOCznQLvWvfYafeuUOh1O7AAB90NPTJOwps77ws8wxAd12Qcad0ScwLD0+Q+8ppaftxghhHsOM+F/bfzI4WInsZuNYxZmo1C9P7vmt6j7zFbEtU4WAzbFuXf1fUOs5CxGc9qGI9Rq4IT3PRMDXpjT04/6dWCRdc2HaGPO9cTjDpNR6BHfFSBLo49HYskxD22uz0bWHrEd+cfl+ub9CLObnPy1Py7nIPntmGpw0ZRGuFrQSKVZr4O9HCVJdEIKF+wu0YXIQy2NZ1P+ILncTFE++GM9iSq9nAnSKNsXrN7biQrPrc5FfjnJXC+DfQlObniq08n9V9tDc2lpo+rxKuFxKaxquw0ywWmM9RUZ8oqWpP3Ezc6KbjIyFLA5Dci7YG9qKZO7Y2IDnrEO2/RNjhQWAg9IjqJrUFa8crsXxJxYlaDgSuBV7dGM/sg8tbp9jHeXbU8r9x9tL+9dcW/pxds5piMkCAwEAAQ==";
    public static String privateKey = "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";

    public static PublicKey getPublicKey(String base64PublicKey)
    {
        PublicKey publicKey = null;
        try 
        {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }   catch (InvalidKeySpecException e)
        {
            e.printStackTrace();
        }
        return publicKey;
    }

    public static PrivateKey getPrivateKey(String base64PrivateKey)
    {
        PrivateKey privateKey = null;
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey.getBytes()));
        KeyFactory keyFactory = null;
        try
        {
            keyFactory = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        try
        {
            privateKey = keyFactory.generatePrivate(keySpec);
        } catch (InvalidKeySpecException e)
        {
            e.printStackTrace();
        }
        return privateKey;
    }

    public static byte [] encrypt(String data, String publicKey)
    throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException
    {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
        return cipher.doFinal(data.getBytes());
    }

    public static String decrypt(byte [] data, PrivateKey privateKey)
    throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
    {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(data));
    }

    public static String decrypt(String data, String base64PrivateKey)
    throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException
    {
        return decrypt(Base64.getDecoder().decode(data.getBytes()), getPrivateKey(base64PrivateKey));
    }

    public static void main(String [] arguments)
    throws IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, BadPaddingException
    {
        try
        {
            String encryptedString = Base64.getEncoder().encodeToString(encrypt("Super Secret Shit tell no one beta", publicKey));
            System.out.println(encryptedString);

            String decryptedString = RSAUtil.decrypt(encryptedString, privateKey);
            System.out.println(decryptedString);
        } catch (NoSuchAlgorithmException e)
        {
            System.err.println(e.getMessage());
        }
    }
}