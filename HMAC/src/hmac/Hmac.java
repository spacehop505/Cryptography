package hmac;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class Hmac {

	private Mac mac;
	private byte[] hmacSignature;
	private String message;
	private String result;


	public Hmac(String message) {
		this.message = message;
	}

	public byte[] getHmacSignature() {
		return hmacSignature;
	}

	public String getMessage() {
		return message;
	}
	
	
	public String getResult() {
		return result;
	}

	public void setHmac(SecretKey key) {
		try {
			mac = Mac.getInstance("HmacSHA256");
			try {
				mac.init(key);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
			
			// HMAC VALUE
			hmacSignature = mac.doFinal(message.getBytes());
			
			// HMAC VALUE IN BASE64
			result = Base64.getEncoder().encodeToString(hmacSignature);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

}
