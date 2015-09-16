package SymmetricEncryptionAndDecryption.Caesar;

import SymmetricEncryptionAndDecryption.EAndD;

/**
 * Created by lotus_work on 2015/9/16.
 * 实现经典的凯撒密码
 */
public class Caesar implements EAndD{
    //26个字母表
    public static String table = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    //默认key,移动3位
    int keys = 3;

    public Caesar(){

    }
    public Caesar(int keys){
        this.keys = keys;
    }
    /**
     * 传入明文，加密得到密文
     *
     * @param plaintext
     * @return
     */
    @Override
    public String encryption(String plaintext) {
        char[] plain = plaintext.toCharArray();
        for(int  i=0;i<plain.length;i++){
            if(!Character.isLetter(plain[i])){
                continue;
            }
            plain[i]=cipher(plain[i]);
        }
        return new String(plain);
    }

    /**
     * 加密轮盘
     * @param str
     * @return
     */
    private  char cipher(char str){
        int position = (table.indexOf(str)+this.keys)%52;
        return table.charAt(position);

    }

    /**
     * 传入明文解密到密文
     *
     * @param ciphertext
     * @return
     */
    @Override
    public String decryption(String ciphertext) {

        char[] plain = ciphertext.toCharArray();
        for(int  i=0;i<plain.length;i++){
            if(!Character.isLetter(plain[i])){
                continue;
            }
            plain[i]=decCipher(plain[i]);
        }
        return new String(plain);
    }
    /**
     * 解密轮盘
     * @param str
     * @return
     */
    private  char decCipher(char str){
        int position = (table.indexOf(str)-this.keys)%52;
        position = position<0?52+position:position;
        return table.charAt(position);

    }

    public static  void  main(String[] s){
        String text = "this is a good word Character.isLetter";
        Caesar caesar = new Caesar(3);
        String ciphertext = caesar.encryption(text);
        System.out.println(ciphertext);
        String plaintext = caesar.decryption(ciphertext);
        System.out.println(plaintext);
    }

}
