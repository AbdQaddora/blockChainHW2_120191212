package com.mycompany.blockchainhw2;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    private static final String HEXADECIMALS = "0123456789abcdef";

    public static String sha256(String textToHash) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(textToHash.getBytes(Charset.defaultCharset()));
        return convertByteArrayToHexString(messageDigest.digest());
    }

    public static String convertByteArrayToHexString(byte[] byteArray) {

        final StringBuilder hexText = new StringBuilder(2 * byteArray.length);

        for (byte byteElement : byteArray) {
            hexText
                    .append(HEXADECIMALS.charAt((byteElement & 0xF0) >> 4))
                    .append(HEXADECIMALS.charAt((byteElement & 0x0F)));
        }

        return hexText.toString();
    }

}
