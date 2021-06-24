package signature;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public class SignatureReceiver {

	private Signature signature;
	private byte[] receivedText;
	private byte[] signatureBytesReceiver;
	private byte[] signatureBytesSender;
	private String value;

	public SignatureReceiver() {

	}

	public SignatureReceiver(byte[] receivedText, byte[] signatureBytesSender) {
		this.receivedText = receivedText;
		this.signatureBytesSender = signatureBytesSender;
	}

	public byte[] getSignatureBytesReceiver() {
		return signatureBytesReceiver;
	}

	public byte[] getSignatureBytesSender() {
		return signatureBytesSender;
	}

	// VERIFY SIGNATURE
	public String verifySignatureReceiver(PublicKey publicKey) {
		try {
			// create signature
			signature = Signature.getInstance("SHA256withDSA");

			// initialise signature
			signature.initVerify(publicKey);

			// add data to signature
			signature.update(receivedText);

			// Verify Signature
			boolean bool = signature.verify(signatureBytesSender);

			if (bool == true) {
				value = "true";
			} else {
				value = "false";
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}
		return value;
	}

}
