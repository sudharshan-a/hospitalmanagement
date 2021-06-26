package bootathonfinal;
import java.util.*;

public class Password {
	

	public static void main(String[] args) {
//		String val = "Subash Natarajan";
	//	String encrypt = encrypt_password(val);
		//System.out.println("Encrypted String "+ encrypt);
		//System.out.println("--------------");
		//String decrypt = decrypt_password("SG9zcGl0YWxAMg== ") ;
		//System.out.println("Decrypted String "+ decrypt);
		System.out.println("--------------");

	}

	 static String decrypt_password(String encrypt) {
		return new String(Base64.getMimeDecoder().decode(encrypt));
	}

	 static String encrypt_password(String val) {
		return Base64.getEncoder().encodeToString(val.getBytes());
	}

}

