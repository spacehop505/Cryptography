package run;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import signature.AsymmetricKeys;
import signature.SignatureReceiver;
import signature.SignatureSender;

public class Gui {

	private PrivateKey privateKey;
	private PublicKey publicKey;
	private byte[] signatureBytesSender;

	private JFrame frame;
	private JTextField m1;
	private JTextField m2;
	private JLabel m3;
	private JLabel keyLbl1;
	private JLabel keyLbl2;
	private JLabel lblEnterText;
	private JLabel lblEnterText_1;
	private JLabel lbl2;
	private JLabel lbl1;
	private JLabel lblHmac;
	private JLabel sig1;
	private JLabel lblSender;
	private JLabel lblReceiver;
	private JLabel lblHmacValueBase;
	private JLabel lblSecretKey_3;
	private JLabel lblHmacValueBase_1;
	private JLabel sig2;
	private JLabel lblText;
	private JLabel b1;
	private JLabel lblText_1;
	private JLabel b2;
	private JLabel lblText_2;

	public Gui() {
		frame = new JFrame();
		frame.setBounds(100, 100, 828, 669);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton senderBtn = new JButton("Generate Signature");
		senderBtn.setBackground(SystemColor.inactiveCaption);
		senderBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = m1.getText();
				SignatureSender signatureSenderObj = new SignatureSender(message.getBytes());
				signatureSenderObj.createSignatureSender(privateKey);
				m2.setText(message);
				b1.setText(message);
				signatureBytesSender = signatureSenderObj.getSignatureBytesSender();
				sig1.setText("" + signatureSenderObj.getSignatureBytesSender());
			}
		});
		senderBtn.setBounds(160, 280, 150, 30);
		frame.getContentPane().add(senderBtn);

		m1 = new JTextField();
		m1.setBounds(160, 230, 150, 30);
		frame.getContentPane().add(m1);
		m1.setColumns(10);

		JButton btnGenerateSecretKey = new JButton("Asymmetric Key");
		btnGenerateSecretKey.setBackground(SystemColor.inactiveCaption);
		btnGenerateSecretKey.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				AsymmetricKeys asymmetricKeysObj = new AsymmetricKeys();
				asymmetricKeysObj.generateAsymmetricKeys();

				privateKey = asymmetricKeysObj.getPrivateKey();
				publicKey = asymmetricKeysObj.getPublicKey();

				keyLbl1.setText(asymmetricKeysObj.getBase64PrivateKey());
				keyLbl2.setText(asymmetricKeysObj.getBase64PublicKey());
			}
		});
		btnGenerateSecretKey.setBounds(405, 80, 150, 30);
		frame.getContentPane().add(btnGenerateSecretKey);

		JButton receiverBtn = new JButton("Generate Signature");
		receiverBtn.setBackground(SystemColor.inactiveCaption);
		receiverBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = m2.getText();
				b2.setText(message);

				SignatureReceiver signatureReceiverObj = new SignatureReceiver(message.getBytes(),
						signatureBytesSender);
				String value = signatureReceiverObj.verifySignatureReceiver(publicKey);
				sig2.setText("" + signatureReceiverObj.getSignatureBytesSender());
				m3.setText(value);
			}
		});
		receiverBtn.setBounds(580, 280, 150, 30);
		frame.getContentPane().add(receiverBtn);

		m2 = new JTextField();
		m2.setColumns(10);
		m2.setBounds(580, 230, 150, 30);
		frame.getContentPane().add(m2);

		m3 = new JLabel("True/False");
		m3.setForeground(new Color(165, 42, 42));
		m3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		m3.setBounds(390, 502, 150, 30);
		frame.getContentPane().add(m3);

		keyLbl1 = new JLabel("NULL");
		keyLbl1.setForeground(new Color(199, 21, 133));
		keyLbl1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		keyLbl1.setBounds(60, 200, 320, 30);
		frame.getContentPane().add(keyLbl1);

		keyLbl2 = new JLabel("NULL");
		keyLbl2.setForeground(new Color(199, 21, 133));
		keyLbl2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		keyLbl2.setBounds(480, 200, 320, 30);
		frame.getContentPane().add(keyLbl2);

		lblEnterText = new JLabel("Enter Text:");
		lblEnterText.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEnterText.setBounds(60, 230, 100, 30);
		frame.getContentPane().add(lblEnterText);

		lblEnterText_1 = new JLabel("Enter Text:");
		lblEnterText_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEnterText_1.setBounds(480, 230, 100, 30);
		frame.getContentPane().add(lblEnterText_1);

		lbl2 = new JLabel("Private Key Base64:");
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl2.setBounds(60, 170, 250, 30);
		frame.getContentPane().add(lbl2);

		lbl1 = new JLabel("Public Key Base64:");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl1.setBounds(480, 170, 250, 30);
		frame.getContentPane().add(lbl1);

		lblHmac = new JLabel("Digital Signature");
		lblHmac.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblHmac.setBounds(247, 11, 318, 40);
		frame.getContentPane().add(lblHmac);

		sig1 = new JLabel("NULL");
		sig1.setForeground(new Color(0, 128, 128));
		sig1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sig1.setBounds(60, 360, 150, 30);
		frame.getContentPane().add(sig1);

		lblSender = new JLabel("Sender");
		lblSender.setForeground(Color.BLUE);
		lblSender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSender.setBounds(60, 140, 250, 30);
		frame.getContentPane().add(lblSender);

		lblReceiver = new JLabel("Receiver");
		lblReceiver.setForeground(Color.BLUE);
		lblReceiver.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReceiver.setBounds(480, 140, 250, 30);
		frame.getContentPane().add(lblReceiver);

		lblHmacValueBase = new JLabel("Signature:");
		lblHmacValueBase.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHmacValueBase.setBounds(60, 330, 250, 30);
		frame.getContentPane().add(lblHmacValueBase);

		lblSecretKey_3 = new JLabel("Generate New Asymmetric Key:");
		lblSecretKey_3.setBackground(new Color(0, 0, 0));
		lblSecretKey_3.setForeground(new Color(199, 21, 133));
		lblSecretKey_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSecretKey_3.setBounds(203, 80, 202, 30);
		frame.getContentPane().add(lblSecretKey_3);

		lblHmacValueBase_1 = new JLabel("Signature Received:");
		lblHmacValueBase_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHmacValueBase_1.setBounds(480, 330, 250, 30);
		frame.getContentPane().add(lblHmacValueBase_1);

		sig2 = new JLabel("NULL");
		sig2.setForeground(new Color(0, 128, 128));
		sig2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sig2.setBounds(480, 360, 150, 30);
		frame.getContentPane().add(sig2);

		lblText = new JLabel("Text:");
		lblText.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblText.setBounds(60, 390, 100, 30);
		frame.getContentPane().add(lblText);

		b1 = new JLabel("NULL");
		b1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		b1.setBounds(160, 390, 100, 30);
		frame.getContentPane().add(b1);

		lblText_1 = new JLabel("Text:");
		lblText_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblText_1.setBounds(480, 390, 100, 30);
		frame.getContentPane().add(lblText_1);

		b2 = new JLabel("NULL");
		b2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		b2.setBounds(580, 390, 100, 30);
		frame.getContentPane().add(b2);

		lblText_2 = new JLabel("Signature Match:");
		lblText_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblText_2.setBounds(240, 502, 140, 30);
		frame.getContentPane().add(lblText_2);
		frame.setVisible(true);
	}
}
