package com.oboz.spam.crypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class Crypt {
    private Cipher cipher;

    public Crypt() throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance("RSA");
    }

    public String encryptText(String text, String publicKey) throws Exception {
        return encryptText(text, getPrivate(publicKey));
    }

    public String encryptText(String text, PrivateKey key) throws InvalidKeyException, UnsupportedEncodingException,
            BadPaddingException, IllegalBlockSizeException {
        this.cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.encodeBase64String(this.cipher.doFinal(text.getBytes("UTF-8")));
    }

    public String decryptText(String text, String publicKey) throws Exception {
        return decryptText(text, getPublic(publicKey));
    }

    public String decryptText(String text, PublicKey key) throws InvalidKeyException, UnsupportedEncodingException,
            IllegalBlockSizeException, BadPaddingException {
        this.cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(this.cipher.doFinal(Base64.decodeBase64(text)), "UTF-8");
    }

    public PrivateKey getPrivate(String privateTextKey) throws Exception {
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateTextKey.getBytes()));
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    public PublicKey getPublic(String publicTextKey) throws Exception {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.decodeBase64(publicTextKey.getBytes()));
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    public byte[] hashEncode(byte[] buffer) {
        return Base64.encodeBase64(buffer);
    }

    public String hashEncode(String value) {
        return new String(hashEncode(value.getBytes()));
    }

    public byte[] hashDecode(byte[] buffer) {
        return Base64.decodeBase64(buffer);
    }

    public String hashDecode(String value) {
        return new String(hashDecode(value.getBytes()));
    }

}
