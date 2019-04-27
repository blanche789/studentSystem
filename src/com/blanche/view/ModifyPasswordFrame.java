package com.blanche.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.blanche.dao.UserDao;
import com.blanche.model.User;
import javax.swing.ImageIcon;

public class ModifyPasswordFrame extends JInternalFrame {
	public static JTextField userName;
	public JPasswordField oldPassword;
	private JPasswordField newPassword;
	private JPasswordField confirmNewPassword;
	private UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyPasswordFrame frame = new ModifyPasswordFrame();
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
	public ModifyPasswordFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(650, 300, 450, 300);
		
		JLabel label = new JLabel("\u7528\u6237\u540D:");
		label.setIcon(new ImageIcon(ModifyPasswordFrame.class.getResource("/images/icon8.png")));
		label.setFont(new Font("��Բ", Font.PLAIN, 20));
		
		userName = new JTextField();
		userName.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		userName.setColumns(10);
		
		JLabel label_1 = new JLabel("\u65E7\u5BC6\u7801:");
		label_1.setIcon(new ImageIcon(ModifyPasswordFrame.class.getResource("/images/icon15.png")));
		label_1.setFont(new Font("��Բ", Font.PLAIN, 20));
		
		JLabel label_2 = new JLabel("\u65B0\u5BC6\u7801:");
		label_2.setIcon(new ImageIcon(ModifyPasswordFrame.class.getResource("/images/icon15.png")));
		label_2.setFont(new Font("��Բ", Font.PLAIN, 20));
		
		JLabel label_3 = new JLabel("\u786E  \u8BA4:");
		label_3.setIcon(new ImageIcon(ModifyPasswordFrame.class.getResource("/images/icon14.png")));
		label_3.setFont(new Font("��Բ", Font.PLAIN, 20));
		
		oldPassword = new JPasswordField();
		oldPassword.setEchoChar('*');
		
		newPassword = new JPasswordField();
		newPassword.setEchoChar('*');
		
		confirmNewPassword = new JPasswordField();
		confirmNewPassword.setEchoChar('*');
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmActionPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(label)
									.addComponent(label_1)))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(confirmNewPassword, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
						.addComponent(newPassword, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
						.addComponent(oldPassword, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
						.addComponent(userName, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
					.addGap(115))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(oldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(newPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(confirmNewPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(22))
		);
		getContentPane().setLayout(groupLayout);
		userName.setText(LoginFram.userName);  //��ȡ��¼ʱ���û���
		userName.setEditable(false); //����Ϊ���ɱ༭
	}
	
	/*
	 * ���������
	 */
	public void resetActionPerformed(ActionEvent e) {
		clear();
	}

	public void confirmActionPerformed(ActionEvent e) {
		this.oldPassword.requestFocus(); //�Զ���ȡ����
		int result;  //�����洢���½�����ص�ֵ
		int tag;  //�����洢ȷ�϶Ի����ֵ
		String oldPassword = new String(this.oldPassword.getPassword());
		String newPassword = new String(this.newPassword.getPassword());
		String confirmPassword = new String(this.confirmNewPassword.getPassword());
		User user1 = userDao.queryByUserName(userName.getText());  //�û�1ͨ���˻�����ԭ������Ϣ
		User user2 = new User(0, userName.getText(), newPassword , null);  //���µ����봫���û�2
		if(newPassword.equals("") || confirmPassword.equals("") || oldPassword.equals("")){
			JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
		}else if(!user1.getPassword().equals(oldPassword)) {
			JOptionPane.showMessageDialog(null, "���������");
			clear();
		}else {
			 if(!newPassword.equals(confirmPassword)) {
				JOptionPane.showMessageDialog(null, "ȷ�����������������벻һ��");
				
			}else{
				tag = JOptionPane.showConfirmDialog(null, "ȷ�ϸ���������?");
				if(tag==0) {
						result = userDao.updatePassword(user2);
						if(result!=0) {
							JOptionPane.showMessageDialog(null, "���³ɹ�");
							clear(); //��������
						}else {
							JOptionPane.showMessageDialog(null, "����ʧ��");
						}
				}else {
					clear();  //��ȡ�����߷�����նԻ���
				}
			}
		}
	}
	/*
	 * ��������
	 */
	public void clear() {
		this.oldPassword.setText("");
		this.newPassword.setText("");;
		this.confirmNewPassword.setText("");
	}
}
