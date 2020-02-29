package com.pibs.util;

import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.sun.jersey.core.util.Base64;


/**
 * 
 * @author dward
 * @since 09Feb2018
 */
public class EncryptUtil {

	 private static Cipher cipher;
     private static SecretKeySpec key;
     private static AlgorithmParameterSpec spec;
     public static final String SEED_16_CHARACTER = "hello";//constant
     
     static {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        digest.update(SEED_16_CHARACTER.getBytes("UTF-8"));
	        byte[] keyBytes = new byte[16];
	        System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);

	        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        key = new SecretKeySpec(keyBytes, "AES");
	        spec = getIV();
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
     
     public static AlgorithmParameterSpec getIV()  {
        byte[] iv = { 0x00, 0x50, 0x00, 0x00, 0x00, 0x00, 0x72, 0x00, 0x00, 0x00, 0x46, 0x00, 0x23, 0x00, 0x00, 0x00 };
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        return ivParameterSpec;
    }

    public static String encrypt(String plainPwd) throws Exception {
    	String pass = null;
    	if (plainPwd!=null) {
            cipher.init(1, key, spec);
            byte[] encrypted = cipher.doFinal(plainPwd.getBytes("UTF-8"));
            pass = new String(Base64.encode(encrypted));    		
    	}
        return pass;
    }

    public static String decrypt(String cryptedPwd) throws Exception {
    	cipher.init(2, key, spec);
    	byte[] bytes = Base64.decode(cryptedPwd);
    	byte[] decrypted = cipher.doFinal(bytes);
    	return new String(decrypted, "UTF-8");
    }
     
    //for Unit Testing only
    public static void main(String[] args) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(SEED_16_CHARACTER.getBytes("UTF-8"));
        byte[] keyBytes = new byte[16];
        System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);

        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        key = new SecretKeySpec(keyBytes, "AES");
        spec = getIV();

        System.out.println(encrypt("esd"));//wAKV3MgJ1xnHzfdMxfNnJA==
        System.out.println(decrypt("wAKV3MgJ1xnHzfdMxfNnJA=="));//esd
        
        System.out.println(encrypt("user1"));//OVOAzqHcytxEb6Mi3jhFnA==
        System.out.println(decrypt("OVOAzqHcytxEb6Mi3jhFnA=="));//user1
    }
    
}
