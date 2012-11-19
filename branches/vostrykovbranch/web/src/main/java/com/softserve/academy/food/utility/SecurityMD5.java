package com.softserve.academy.food.utility;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityMD5 {
    private MessageDigest md5;
    private String type = "md5";

    public SecurityMD5() {
    }

    public SecurityMD5(String type) {
        this.type = type;
    }

    public String getHash(String str) {

        String hashedPass;

        try {
            md5 = MessageDigest.getInstance(type);
            md5.update(str.getBytes(), 0, str.length());
            hashedPass = new BigInteger(1, md5.digest()).toString(16);
            if (hashedPass.length() < 32) {
                hashedPass = "0" + hashedPass;
            }
        } catch (NoSuchAlgorithmException e) {
            return e.toString();
        }

        return hashedPass;
    }

    public String get(String str) {
        MessageDigest md5;
        StringBuffer hexString = new StringBuffer();

        try {

            md5 = MessageDigest.getInstance(type);

            md5.reset();
            md5.update(str.getBytes());

            byte messageDigest[] = md5.digest();

            for (int i = 0; i < messageDigest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            }

        } catch (NoSuchAlgorithmException e) {
            return e.toString();
        }

        return hexString.toString();
    }

}