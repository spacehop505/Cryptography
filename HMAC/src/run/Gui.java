package run;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.crypto.SecretKey;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hmac.Hmac;
import hmac.SecretKey1;

public class Gui {
	private SecretKey key;
	private byte[] hmacSignature1;
	private byte[] hmacSignature2;
	private JFrame frame;
	private JTextField m1;
	private JTextField m2;
	private JLabel m3;
	private JLabel keyLbl1;
	private JLabel keyLbl2;
	private JLabel lblEnterText;
	private JLabel lblEnterText_1;
	private JLabel lblSecretKey;
	private JLabel lblSecretKey_1;
	private JLabel lblHmac;
	private JLabel hmacLbl1;
	private JLabel lblSender;
	private JLabel lblReceiver;
	private JLabel lblHmacValueBase;
	private JLabel lblSecretKey_3;
	private JLabel lblHmacValueBase_1;
	private JLabel hmacLbl2;
	private JLabel lblSecretKey_2;
	private JLabel lblText;
	private JLabel b1;
	private JLabel lblText_1;
	private JLabel b2;

	public Gui() {
		frame = new JFrame();
		frame.setBounds(100, 100, 828, 669);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton senderBtn = new JButton("Generate HMAC");
		senderBtn.setBackground(SystemColor.inactiveCaption);
		senderBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = m1.getText();
				Hmac hmacObj = new Hmac(message);
				hmacObj.setHmac(key);
				hmacSignature1 = hmacObj.getHmacSignature();
				m2.setText(message);
				b1.setText(message);
				hmacLbl1.setText(hmacObj.getResult());
			}
		});
		senderBtn.setBounds(160, 280, 150, 30);
		frame.getContentPane().add(senderBtn);

		m1 = new JTextField();
		m1.setBounds(160, 230, 150, 30);
		frame.getContentPane().add(m1);
		m1.setColumns(10);

		JButton btnGenerateSecretKey = new JButton("Secret Key");
		btnGenerateSecretKey.setBackground(SystemColor.inactiveCaption);
		btnGenerateSecretKey.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SecretKey1 secretKeyObj = new SecretKey1();
				secretKeyObj.generateSecretKey();
				key = secretKeyObj.getSecretKey();

				keyLbl1.setText(secretKeyObj.getEncodedKey());
				keyLbl2.setText(secretKeyObj.getEncodedKey());
			}
		});
		btnGenerateSecretKey.setBounds(405, 80, 150, 30);
		frame.getContentPane().add(btnGenerateSecretKey);

		JButton receiverBtn = new JButton("Generate HMAC");
		receiverBtn.setBackground(SystemColor.inactiveCaption);
		receiverBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = m2.getText();
				Hmac hmacObj = new Hmac(message);
				hmacObj.setHmac(key);
				hmacSignature2 = hmacObj.getHmacSignature();
				hmacLbl2.setText(hmacObj.getResult());
				b2.setText(message);
			}
		});
		receiverBtn.setBounds(580, 280, 150, 30);
		frame.getContentPane().add(receiverBtn);

		m2 = new JTextField();
		m2.setColumns(10);
		m2.setBounds(580, 230, 150, 30);
		frame.getContentPane().add(m2);

		JButton btnCompareHmac = new JButton("Compare HMAC");
		btnCompareHmac.setBackground(SystemColor.inactiveCaption);
		btnCompareHmac.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Arrays.equals(hmacSignature1, hmacSignature2) == true) {
					m3.setText("True");
				} else {
					m3.setText("False");
				}
			}
		});
		btnCompareHmac.setBounds(405, 470, 150, 30);
		frame.getContentPane().add(btnCompareHmac);

		m3 = new JLabel("True/False");
		m3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		m3.setBounds(405, 500, 150, 30);
		frame.getContentPane().add(m3);

		keyLbl1 = new JLabel("NULL");
		keyLbl1.setForeground(new Color(199, 21, 133));
		keyLbl1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		keyLbl1.setBounds(60, 200, 320, 30);
		frame.getContentPane().add(keyLbl1);

		keyLbl2 = new JLabel("NULL");
		keyLbl2.setForeground(new Color(199, 21, 133));
		keyLbl2.setFont(new Font("Tahoma", Font.PLAIN, 12));
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

		lblSecretKey = new JLabel("Secret Key Base64:");
		lblSecretKey.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSecretKey.setBounds(60, 170, 250, 30);
		frame.getContentPane().add(lblSecretKey);

		lblSecretKey_1 = new JLabel("Secret Key Base64:");
		lblSecretKey_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSecretKey_1.setBounds(480, 170, 250, 30);
		frame.getContentPane().add(lblSecretKey_1);

		lblHmac = new JLabel("HMAC");
		lblHmac.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblHmac.setBounds(343, 11, 126, 40);
		frame.getContentPane().add(lblHmac);

		hmacLbl1 = new JLabel("NULL");
		hmacLbl1.setForeground(new Color(0, 128, 128));
		hmacLbl1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		hmacLbl1.setBounds(60, 360, 320, 30);
		frame.getContentPane().add(hmacLbl1);

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

		lblHmacValueBase = new JLabel("HMAC Value Base64:");
		lblHmacValueBase.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHmacValueBase.setBounds(60, 330, 250, 30);
		frame.getContentPane().add(lblHmacValueBase);

		lblSecretKey_3 = new JLabel("Generate New Secret Key:");
		lblSecretKey_3.setBackground(new Color(0, 0, 0));
		lblSecretKey_3.setForeground(new Color(199, 21, 133));
		lblSecretKey_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSecretKey_3.setBounds(235, 80, 170, 30);
		frame.getContentPane().add(lblSecretKey_3);

		lblHmacValueBase_1 = new JLabel("HMAC Value Base64:");
		lblHmacValueBase_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHmacValueBase_1.setBounds(480, 330, 250, 30);
		frame.getContentPane().add(lblHmacValueBase_1);

		hmacLbl2 = new JLabel("NULL");
		hmacLbl2.setForeground(new Color(0, 128, 128));
		hmacLbl2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		hmacLbl2.setBounds(480, 360, 320, 30);
		frame.getContentPane().add(hmacLbl2);

		lblSecretKey_2 = new JLabel("Compare HMAC Value:");
		lblSecretKey_2.setForeground(new Color(0, 128, 128));
		lblSecretKey_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSecretKey_2.setBounds(235, 470, 170, 30);
		frame.getContentPane().add(lblSecretKey_2);

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
		frame.setVisible(true);
	}
}
