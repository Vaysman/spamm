package com.oboz.spam.tools;

import com.oboz.spam.crypt.Crypt;
import com.oboz.spam.crypt.GenerateKeys;
import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class CryptGeneratesKeys {


    public static void main(String[] args) throws Exception {
        GenerateKeys generateKeys;
        try {
            generateKeys = new GenerateKeys(1024);
            byte[] publicKey = generateKeys.getPublicKey().getEncoded();
            byte[] privateKey = generateKeys.getPrivateKey().getEncoded();
            generateKeys.writeToFile("KeyPair/publicKey", publicKey);
            generateKeys.writeToFile("KeyPair/privateKey", privateKey);
            String encodedPublicString = new String(Base64.encodeBase64(publicKey));
            String encodedPrivateString = new String(Base64.encodeBase64(privateKey));
            System.out.println("Public key : " + encodedPublicString);
            System.out.println("Private key : " + encodedPrivateString);
            Crypt crypt = new Crypt();
            String originalMessage = "Good text!!!";
            System.out.println("Original text : " + originalMessage);
            String en = crypt.encryptText(originalMessage, encodedPrivateString);
            System.out.println("Encrypted text : " + en);
            String de = crypt.decryptText(en, encodedPublicString);
            System.out.println("Decrypted text : " + de);

            String password = "ffffffffffffffffffffff";
            System.out.println("Hashed password : " + crypt.hashEncode(password));


        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
