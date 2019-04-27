package com.blanche.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.blanche.dao.UserDao;
import com.blanche.model.User;

import com.blanche.util.StringUtil;
import javax.swing.ImageIcon;

public class RegisteFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisteFrame frame = new RegisteFrame();
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
	public RegisteFrame() {
		setTitle("\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setIcon(new ImageIcon(RegisteFrame.class.getResource("/images/icon8.png")));
		label.setFont(new Font("幼圆", Font.PLAIN, 21));
		label.setBounds(63, 57, 125, 21);
		contentPane.add(label);
		
		userName = new JTextField();
		userName.setBounds(169, 57, 158, 24);
		contentPane.add(userName);
		userName.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_1.setIcon(new ImageIcon(RegisteFrame.class.getResource("/images/icon15.png")));
		label_1.setFont(new Font("幼圆", Font.PLAIN, 21));
		label_1.setBounds(63, 106, 153, 31);
		contentPane.add(label_1);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmActionPerformed(e);
			}
		});
		button.setBounds(90, 162, 85, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		button_1.setBounds(189, 162, 89, 27);
		contentPane.add(button_1);
		
		password = new JPasswordField();
		password.setEchoChar('*');
		password.setBounds(169, 111, 158, 24);
		contentPane.add(password);
		
		JButton button_2 = new JButton("\u8FD4\u56DE\u767B\u5F55");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginFram().setVisible(true);
			}
		});
		button_2.setBounds(292, 162, 102, 27);
		contentPane.add(button_2);
		//使窗口居中
		this.setLocationRelativeTo(null);
	}

	public void confirmActionPerformed(ActionEvent e) {
		String userName = this.userName.getText();
		String password = new String(this.password.getPassword());

		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return ;
		}else if(StringUtil.isEmpty(password)){
			this.password.grabFocus();
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return ;
		}
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setRight("user");
		UserDao userDao = new UserDao();
		
		if(userDao.queryByUserName(userName) != null) {
			JOptionPane.showMessageDialog(null, "用户名已存在");
		}else {
			
			userDao.saveUser(user);
			JOptionPane.showMessageDialog(null, "注册用户名成功");
		}
		
	}

	public void resetActionPerformed(ActionEvent e) {
		userName.setText(""); 
		password.setText("");
		
	}
}
