package com.bbringworld.ezparkapi.global.util;

import com.bbringworld.ezparkapi.global.exception.advice.TotalServerException;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class Aes256 {

    final private static String IV = "https://api.ezpark.xyz";
    final private static String KEY = "api.ezpark.xyz";

    public static String encrypt(String str) {
        return encrypt(str, IV);
    }

    public static String encrypt(String str, String ivStr) {
        try {
            byte[] keyBytes = KEY.substring(0, 14).getBytes(StandardCharsets.UTF_8);
            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
            String iv = getIv(ivStr);

            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8)));

            byte[] encrypted = c.doFinal(str.getBytes(StandardCharsets.UTF_8));

            return new String(Base64.encodeBase64(encrypted, true));
        } catch (Exception e) {
            throw new TotalServerException("---During encryption, there is error!---");
        }
    }

    public static String decrypt(String str) {
        return decrypt(str, IV);
    }

    public static String decrypt(String str, String ivString) {
        try {
            byte[] keyBytes = KEY.substring(0, 14).getBytes(StandardCharsets.UTF_8);
            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
            String iv = getIv(ivString);
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8)));

            byte[] byteStr = Base64.decodeBase64(str);

            return new String(c.doFinal(byteStr), StandardCharsets.UTF_8);
        } catch(Exception e) {
            throw new TotalServerException("---During decryption, there is error!---");
        }
    }

    public static String getIv(String iv) {
        if (iv == null) {
            return IV.substring(0, 14);
        } else if (iv.length() >= 13) {
            return iv.substring(0, 14);
        } else {
            return StringUtils.rightPad(iv, 28).substring(0, 14);
        }
    }
}