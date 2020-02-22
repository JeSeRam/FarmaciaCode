/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROYECTO.FuncionesParalelas;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;

/**
 *
 * @author Freak
 */
public class Contraseña {
    private final static String alg = "AES";
    private final static String cI = "AES/CBC/PKCS5Padding";
    private final static String key = "92AE31A79FEEB2A3"; 
    private final static String iv = "0123456789ABCDEF";
    /**
     *
     * @param Password
     * @return
     */
    public static String Desifrado(char[] Password){
        String PassWordDes = "";
        PassWordDes = new String(Password);
        return PassWordDes;
    }
    public static String encrypt(String cleartext) {
        byte[] encrypted = null;
        try {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            encrypted = cipher.doFinal(cleartext.getBytes());
        } catch(Exception ex){
            
        }
        return new String(encodeBase64(encrypted));
    }
    public static String decrypt(String encrypted) {
        byte[] decrypted = null;
        try {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            byte[] enc = decodeBase64(encrypted);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
            decrypted = cipher.doFinal(enc);
        } catch(Exception ex){
            
        }
        return new String(decrypted);
    }
}
