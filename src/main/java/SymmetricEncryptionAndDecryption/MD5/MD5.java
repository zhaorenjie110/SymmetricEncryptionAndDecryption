package SymmetricEncryptionAndDecryption.MD5;

import java.security.MessageDigest;

/**
 * Created by lotus_work on 2015/9/16.
 */
public class MD5 {
    /**
     * 对密码进行md5加密
     *
     * @param password 明文密码
     * @return 加密后的密码
     */
    public static String encPassword(String password) {

        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        byte[] strTemp = password.getBytes();
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
