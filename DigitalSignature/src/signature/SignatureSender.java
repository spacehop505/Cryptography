package signature;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;

public class SignatureSender {
	private Signature signature;
	private byte[] sendText;
	private byte[] signatureBytesSender;

	public SignatureSender() {

	}

	public SignatureSender(byte[] sendText) {
		this.sendText = sendText;
	}

	public byte[] getSignatureBytesSender() {
		return signatureBytesSender;
	}

	// CREATE SIGNATURE
	public void createSignatureSender(PrivateKey privateKey) {
		try {
			// create signature
			signature = Signature.getInstance("SHA256withDSA");

			// initialise signature
			signature.initSign(privateKey);

			// add byte data to signature
			signature.update(sendText);

			// calculates the signature
			signatureBytesSender = signature.sign();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}
	}

}
