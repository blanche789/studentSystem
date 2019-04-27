package com.blanche.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.blanche.dao.StudentInfoDao;
import com.blanche.model.StudentInfo;

public class AddStudentInfoFrame extends JInternalFrame {
	private JTextField studentNum;
	private JTextField studentName;
	private JTextField studentAge;
	private JTextField studentAcademy;
	private JTextField studentClass;
	private JTextField telephone;
	private JRadioButton manButton;
	private JRadioButton womenButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentInfoFrame frame = new AddStudentInfoFrame();
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
	public AddStudentInfoFrame() {
		
		setClosable(true);
		setIconifiable(true);
		setTitle("\u589E\u52A0\u5B66\u751F\u8868\u8BB0\u5F55");
		setBounds(100, 100, 377, 423);
		
		JLabel label = new JLabel("\u5B66\u53F7\uFF1A");
		label.setIcon(new ImageIcon(AddStudentInfoFrame.class.getResource("/images/icon7 .png")));
		label.setFont(new Font("幼圆", Font.PLAIN, 21));
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(AddStudentInfoFrame.class.getResource("/images/icon8.png")));
		label_1.setFont(new Font("幼圆", Font.PLAIN, 21));
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		label_2.setIcon(new ImageIcon(AddStudentInfoFrame.class.getResource("/images/icon9.png")));
		label_2.setFont(new Font("幼圆", Font.PLAIN, 21));
		
		JLabel label_3 = new JLabel("\u5E74\u9F84\uFF1A");
		label_3.setIcon(new ImageIcon(AddStudentInfoFrame.class.getResource("/images/icon13.png")));
		label_3.setFont(new Font("幼圆", Font.PLAIN, 21));
		
		JLabel label_4 = new JLabel("\u5B66\u9662\uFF1A");
		label_4.setIcon(new ImageIcon(AddStudentInfoFrame.class.getResource("/images/icon10.png")));
		label_4.setFont(new Font("幼圆", Font.PLAIN, 21));
		
		JLabel label_5 = new JLabel("\u73ED\u7EA7\uFF1A");
		label_5.setIcon(new ImageIcon(AddStudentInfoFrame.class.getResource("/images/icon11.png")));
		label_5.setFont(new Font("幼圆", Font.PLAIN, 21));
		
		JLabel label_6 = new JLabel("\u7535\u8BDD\uFF1A");
		label_6.setIcon(new ImageIcon(AddStudentInfoFrame.class.getResource("/images/icon12.png")));
		label_6.setFont(new Font("幼圆", Font.PLAIN, 21));
		
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
		
		studentNum = new JTextField();
		studentNum.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		studentNum.setColumns(10);
		
		studentName = new JTextField();
		studentName.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		studentName.setColumns(10);
		
		studentAge = new JTextField();
		studentAge.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		studentAge.setColumns(10);
		
		studentAcademy = new JTextField();
		studentAcademy.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		studentAcademy.setColumns(10);
		
		studentClass = new JTextField();
		studentClass.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		studentClass.setColumns(10);
		
		telephone = new JTextField();
		telephone.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		telephone.setColumns(10);
		manButton = new JRadioButton("\u7537");
		manButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		womenButton = new JRadioButton("\u5973");
		womenButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		womenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manButton.setSelected(false);
			}
		});
		 
		manButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//点击性别男,则性别女不选择
				womenButton.setSelected(false);
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(studentClass))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(studentAcademy))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(studentName))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(button)
									.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
									.addComponent(button_1))
								.addComponent(telephone)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(studentNum, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3)
								.addComponent(label_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(manButton)
									.addGap(18)
									.addComponent(womenButton))
								.addComponent(studentAge))))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(studentNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(studentName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(manButton)
						.addComponent(womenButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(studentAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(studentAcademy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(studentClass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(telephone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addGap(60))
		);
		getContentPane().setLayout(groupLayout);
		this.setLocation(700, 300);
	}
	public void confirmActionPerformed(ActionEvent e) {
		int result;
		String num = this.studentNum.getText();
		String name = this.studentName.getText();
		String sex;
		if(manButton.isSelected()) {
			sex = manButton.getText();
		}else if(womenButton.isSelected()) {
			sex = womenButton.getText();
		}else {
			sex = "";
		}
		
	
		String academy = this.studentAcademy.getText();
		String studentClass = this.studentClass.getText();
		String telephone = this.telephone.getText();
		
		if(num.equals("")) {
			JOptionPane.showMessageDialog(null, "学号不能为空");
			return ;
		}else if(num.length()!=10) {
			JOptionPane.showMessageDialog(null, "学号长度为10位");
			return ;
		}else if(!num.matches("311[0-9]+")) {
			JOptionPane.showMessageDialog(null, "学号类型错误");
			return;
		}else if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "姓名不能为空");
				return ;
			}else if(sex.equals("")) {
				JOptionPane.showMessageDialog(null, "性别不能为空");
				return ;
			}else if(!sex.matches("男||女")) {
				JOptionPane.showMessageDialog(null, "性别类型错误");
				return;
			}else if(academy.equals("")) {
				JOptionPane.showMessageDialog(null, "学院不能为空");
				return ;
			}else if(studentClass.equals("")) {
				JOptionPane.showMessageDialog(null, "班级不能为空");
				return ;
			}else if(telephone.equals("")) {
				JOptionPane.showMessageDialog(null, "手机号不能为空");
				return ;
			}else if(telephone.length() != 11) {
			JOptionPane.showMessageDialog(null, "手机号必须为11位");
			return;
		}
		else if(!telephone.matches("^(1[38]\\d{9}|15[012356789]\\d{8}|14[57]\\d{8}|17[678]\\d{8})$")) {
			JOptionPane.showMessageDialog(null, "手机号类型错误");
			return;
		}
		int age = Integer.parseInt(this.studentAge.getText());
		if(Integer.toString(age).equals("")) {
			JOptionPane.showMessageDialog(null, "年龄不能为空");
			return;
		}
		StudentInfo studentInfo = new StudentInfo(0, num, name, sex, age, studentClass, academy, telephone);
		StudentInfoDao studentInfoDao = new StudentInfoDao();
		result = studentInfoDao.addInfo(studentInfo);
		if(result!=0) {
			JOptionPane.showMessageDialog(null, "添加成功");
		}else {
			JOptionPane.showMessageDialog(null, "学号已存在");
		}
		
	}

	/*
	 * 重置学生记录
	 */
	public void resetActionPerformed(ActionEvent e) {
//		String num = this.studentNum.getText();
//		String name = this.studentName.getText();
//		String sex = this.studentSex.getText();
//		int age = Integer.parseInt(this.studentAge.getText());
//		String academy = this.studentAcademy.getText();
//		String studentClass = this.studentClass.getText();
//		String telephone = this.telephone.getText();
		this.studentNum.setText("");
		this.studentName.setText("");
		this.manButton.setSelected(false);
		this.womenButton.setSelected(false);
		
		this.studentAge.setText("");
		this.studentAcademy.setText("");
		this.studentClass.setText("");
		this.telephone.setText("");
	}
}
