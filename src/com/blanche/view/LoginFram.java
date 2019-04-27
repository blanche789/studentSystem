package com.blanche.view;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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

public class LoginFram extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	public static String  userName;
	private String password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFram frame = new LoginFram();
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
	public LoginFram() {
		setTitle("\u767B\u5F55");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700,390 , 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setToolTipText("userName");
		label.setIcon(new ImageIcon(LoginFram.class.getResource("/images/icon.png")));
		label.setFont(new Font("幼圆", Font.PLAIN, 20));
		label.setBounds(59, 84, 110, 35);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_1.setToolTipText("password");
		label_1.setIcon(new ImageIcon(LoginFram.class.getResource("/images/icon2.png")));
		label_1.setFont(new Font("幼圆", Font.PLAIN, 20));
		label_1.setBounds(59, 132, 110, 24);
		contentPane.add(label_1);
		
		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		userNameTxt.setBounds(170, 91, 146, 24);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		label_2.setIcon(new ImageIcon(LoginFram.class.getResource("/images/icon3.png")));
		label_2.setFont(new Font("幼圆", Font.PLAIN, 21));
		label_2.setBounds(116, 26, 209, 35);
		contentPane.add(label_2);
		
		Button button_1 = new Button("\u767B\u5F55");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});

		button_1.setFont(new Font("幼圆", Font.PLAIN, 16));
	
		
		button_1.setBounds(83, 186, 87, 25);
		contentPane.add(button_1);
		
		Button button = new Button("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisteFrame().setVisible(true);
//				registeActionPerformed(e);
			}
		});
		button.setFont(new Font("幼圆", Font.PLAIN, 17));
		button.setBounds(187, 186, 87, 25);
		contentPane.add(button);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		passwordTxt.setEchoChar('*');
		passwordTxt.setBounds(171, 132, 145, 24);
		contentPane.add(passwordTxt);
		
		Button button_2 = new Button("\u91CD\u7F6E");
		button_2.setFont(new Font("幼圆", Font.PLAIN, 17));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 resetActionPerformed(e);
			}
		});
		button_2.setBounds(291, 186, 87, 25);
		contentPane.add(button_2);
		
		//设置JFrame居中
		this.setLocationRelativeTo(null);
	}

	public void resetActionPerformed(ActionEvent e) {
		
			userNameTxt.setText(""); 
			passwordTxt.setText("");
			
	
	}

//	public void registeActionPerformed(ActionEvent e) {
//		 userName = this.userNameTxt.getText();
//		 password = new String(this.passwordTxt.getPassword());
//		if(StringUtil.isEmpty(userName)) {
//			JOptionPane.showMessageDialog(null, "用户名不能为空");
//			return ;
//		}
//		if(StringUtil.isEmpty(password)){
//			JOptionPane.showMessageDialog(null, "密码不能为空");
//			return ;
//		}
//		User user = new User();
//		user.setUserName(userName);
//		user.setPassword(password);
//		UserDao userDao = new UserDao();
//		
//		if(userDao.queryByUserName(userName) != null) {
//			JOptionPane.showMessageDialog(null, "用户名已存在");
//		}else {
//			userDao.saveUser(user);
//			JOptionPane.showMessageDialog(null, "注册用户名成功");
//		}
//	}

	public void loginActionPerformed(ActionEvent e) {
		 userName = this.userNameTxt.getText();
		 password = new String(this.passwordTxt.getPassword());
		
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return ;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return ;
		}
		
		UserDao userDao = new UserDao();
		User user = userDao.queryByUserName(userName);
		
		if(user != null) {
			if(user.getPassword().equals(password)) {
				//使登录窗体消失,释放部分资源,
				dispose();
				//使主界面浮现
				MainFrame mf = new MainFrame();
				mf.setVisible(true);
//				mf.menuItem_1.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, "密码错误");
			}
		}else {
			JOptionPane.showMessageDialog(null, "用户名不存在");
		}
	
	}
}
