package com.blanche.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Font;

public class DesignerFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesignerFrame frame = new DesignerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DesignerFrame() {
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDFv1.0");
		setClosable(true);
		setIconifiable(true);
		setBounds(700, 300, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblblanche = new JLabel("\u5F00\u53D1\u4EBA\u5458:\u5DEB\u57F9\u6770(Blanche)");
		lblblanche.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblblanche.setBounds(120, 44, 226, 18);
		getContentPane().add(lblblanche);
		
		JLabel label = new JLabel("\u73ED\u7EA7:\u8BA1\u79D16\u73ED");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		label.setBounds(120, 73, 226, 18);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5B66\u53F7:3117004669");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		label_1.setBounds(120, 104, 226, 18);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u5B66\u6821\u4FE1\u606F:\u5E7F\u4E1C\u5DE5\u4E1A\u5927\u5B66");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		label_2.setBounds(120, 133, 226, 18);
		getContentPane().add(label_2);
		
		JLabel lblblanchecom = new JLabel("\u7535\u5B50\u90AE\u7BB1:blanche789@163.com");
		lblblanchecom.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblblanchecom.setBounds(120, 164, 290, 18);
		getContentPane().add(lblblanchecom);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(DesignerFrame.class.getResource("/images/icon21.png")));
		label_3.setBounds(35, 87, 48, 61);
		getContentPane().add(label_3);

	}

}
