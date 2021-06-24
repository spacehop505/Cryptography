package signature;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class AsymmetricKeys {

	private KeyPairGenerator keyGen;
	private PrivateKey privateKey;
	private PublicKey publicKey;
	private String base64PublicKey;
	private String base64PrivateKey;

	public AsymmetricKeys() {

	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}

	public String getBase64PublicKey() {
		return base64PublicKey;
	}

	public String getBase64PrivateKey() {
		return base64PrivateKey;
	}

	public void generateAsymmetricKeys() {

		try {
			keyGen = KeyPairGenerator.getInstance("DSA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		keyGen.initialize(2048);
		KeyPair pair = keyGen.generateKeyPair();

		privateKey = pair.getPrivate();
		publicKey = pair.getPublic();

		base64PublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
		base64PrivateKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());

	}

}
