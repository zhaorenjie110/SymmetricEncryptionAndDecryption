package SymmetricEncryptionAndDecryption.Vigenere;

public class Vigenere {
	private String cipherKey;
	private String data;
	private boolean mode;
	Vigenere(){
		this.cipherKey = null;
		this.data = null;
		this.mode = true;
	}
	Vigenere(String data , String cipherKey ,  boolean mode){
		this.cipherKey=cipherKey;
		this.data=data;
		this.mode=mode;
	}
	private char[] toArray(String inString){
		char[] Array=inString.toCharArray();
		return Array;
	}
	private String  toString(char[] Array){
		String Cstring = String.valueOf(Array);
		return Cstring;
	}
	private String encrypt(){
		char[] dataArray= this.toArray(this.data);
		char[] cipherKeyArray=this.toArray(this.cipherKey);
		char[] cipherArray = new char[dataArray.length]; 
		for(int i=0 ; i<dataArray.length/cipherKeyArray.length+1 ; i++){
			for(int t = 0 ; t < cipherKeyArray.length ; t++){
				if(t+i*cipherKeyArray.length < dataArray.length){
					char dataChar=dataArray[t+i*cipherKeyArray.length] ;
					char cipherKeyChar= cipherKeyArray[t];
					cipherArray[t+i*cipherKeyArray.length] = (char)((dataChar+cipherKeyChar-64)%95+32 );
				}
			}
		}
		String cipher=this.toString(cipherArray);
		return cipher;
	}
	private String decrypt(){
		char[]dataArray=this.toArray(this.data);
		char[]cipherKeyArray=this.toArray(this.cipherKey);
		char[] clearArray = new char[dataArray.length];
		for (int i=0 ; i<dataArray.length ; i++){
			for (int t=0 ; t<cipherKeyArray.length ; t++){
				if(t+i*cipherKeyArray.length < dataArray.length){
					char dataChar=dataArray[t+i*cipherKeyArray.length];
					char cipherKeyChar= cipherKeyArray[t];
					if(dataChar-cipherKeyChar>=0){
						clearArray[t+i*cipherKeyArray.length]= (char)((dataChar-cipherKeyChar)%95+32);
					}else{
						clearArray[t+i*cipherKeyArray.length]=(char)((dataChar-cipherKeyChar+95)%95+32);
					}
				}
			}
		}
		String clear = this.toString(clearArray);
		return clear;
	}
	public String en_decrypt(){
		if(this.mode){
			return this.encrypt();
		}else{
			return this.decrypt();
		}
	}

    public static void main(String[] s){
        String text = "this is a good world";
        Vigenere v = new Vigenere(text,"hahhnishi1",true);
        String text2 = v.en_decrypt();
        System.out.println(text2);
        Vigenere v1 = new Vigenere(text2,"hahhnishi1",false);
        System.out.println(v1.en_decrypt());

    }
}
