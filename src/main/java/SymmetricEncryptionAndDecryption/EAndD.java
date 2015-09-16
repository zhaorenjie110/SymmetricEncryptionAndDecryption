package SymmetricEncryptionAndDecryption;

/**
 * Created by lotus_work on 2015/9/16.
 * 加解密基础接口
 */
public interface EAndD {
    /**
     * 传入明文，加密得到密文
     * @param plaintext
     * @return
     */
    public String encryption(String plaintext);

    /**
     * 传入明文解密到密文
     * @param ciphertext
     * @return
     */
    public String decryption(String ciphertext);
}
