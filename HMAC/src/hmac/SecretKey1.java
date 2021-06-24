package hmac;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class SecretKey1 {

	private SecretKey secretKey;
	private String encodedKey;

	public SecretKey1() {

	}

	// GENERATE SECRET KET
	public void generateSecretKey() {
		try {
			KeyGenerator kg = KeyGenerator.getInstance("HmacSHA256");
			
			// SECRET KEY
			secretKey = kg.generateKey();
			
			// BASE64 ENCODE SECRET KEY
			encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public SecretKey getSecretKey() {
		return secretKey;
	}

	public String getEncodedKey() {
		return encodedKey;
	}
}
